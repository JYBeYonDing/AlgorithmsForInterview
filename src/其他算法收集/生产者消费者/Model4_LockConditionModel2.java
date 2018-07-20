package 其他算法收集.生产者消费者;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 杨杰 on 2018/7/11 12:24.
 * 如果做一些实验，你会发现，实现一的并发性能高于实现二、三。
 * 暂且不关心BlockingQueue的具体实现，来分析看如何优化实现三（与实现二的思路相同，性能相当）的性能。
 *
 * 实际上，如果缓冲区是一个队列的话，“生产者将产品入队”与“消费者将产品出队”两个操作之间没有同步关系，
 * 可以在队首出队的同时，在队尾入队。理想性能可提升至实现三的两倍。
 *
 * 那么思路就简单了：需要两个锁 CONSUME_LOCK与PRODUCE_LOCK，CONSUME_LOCK控制消费者线程并发出队，
 * PRODUCE_LOCK控制生产者线程并发入队；
 * 相应需要两个条件变量NOT_EMPTY与NOT_FULL，
 * NOT_EMPTY负责控制消费者线程的状态（阻塞、运行），
 * NOT_FULL负责控制生产者线程的状态（阻塞、运行）。
 * 以此让优化消费者与消费者（或生产者与生产者）之间是串行的；消费者与生产者之间是并行的。
 *
 * 需要注意的是，由于需要同时在UnThreadSafe的缓冲区 buffer 上进行消费与生产，
 * 我们不能使用实现二、三中使用的队列了，需要自己实现一个简单的缓冲区 Buffer。Buffer要满足以下条件：
 在头部出队，尾部入队
 在poll()方法中只操作head
 在offer()方法中只操作tail

 还能进一步优化吗？
 我们已经优化掉了消费者与生产者之间的瓶颈，还能进一步优化吗？

 如果可以，必然是继续优化消费者与消费者（或生产者与生产者）之间的并发性能。
 然而，消费者与消费者之间必须是串行的，因此，并发模型上已经没有地方可以继续优化了。

 不过在具体的业务场景中，一般还能够继续优化。如：
 并发规模中等，可考虑使用CAS代替重入锁
 模型上不能优化，但一个消费行为或许可以进一步拆解、优化，从而降低消费的延迟
 一个队列的并发性能达到了极限，可采用“多个队列”（如分布式消息队列等）



 文章开头说：这4种写法的本质相同——都是在使用或实现BlockingQueue。
 实现一直接使用BlockingQueue，实现四实现了简单的BlockingQueue，而实现二、三则实现了退化版的BlockingQueue（性能降低一半）。
 实现一使用的BlockingQueue实现类是LinkedBlockingQueue。
 */
public class Model4_LockConditionModel2 implements Model{
    private final Lock CONSUME_LOCK = new ReentrantLock();
    private final Condition NOT_EMPTY = CONSUME_LOCK.newCondition();
    private final Lock PRODUCE_LOCK = new ReentrantLock();
    private final Condition NOT_FULL = PRODUCE_LOCK.newCondition();
    private final Buffer<Task> buffer = new Buffer<>();
    private AtomicInteger bufLen = new AtomicInteger(0);
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);
    public Model4_LockConditionModel2(int cap) {
        this.cap = cap;
    }
    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }
    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }
    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            int newBufSize = -1;
            CONSUME_LOCK.lockInterruptibly();
            try {
                while (bufLen.get() == 0) {
                    System.out.println("buffer is empty...");
                    NOT_EMPTY.await();
                }
                Task task = buffer.poll();
                newBufSize = bufLen.decrementAndGet();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume: " + task.no);
                if (newBufSize > 0) {
                    NOT_EMPTY.signalAll();// 通知其他消费者线程启动
                }
            } finally {
                CONSUME_LOCK.unlock();
            }
            if (newBufSize < cap) {// 如果没有生产满，通知生产者线程启动
                PRODUCE_LOCK.lockInterruptibly();
                try {
                    NOT_FULL.signalAll();
                } finally {
                    PRODUCE_LOCK.unlock();
                }
            }
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            int newBufSize = -1;
            PRODUCE_LOCK.lockInterruptibly();
            try {
                while (bufLen.get() == cap) {
                    System.out.println("buffer is full...");
                    NOT_FULL.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                newBufSize = bufLen.incrementAndGet();
                System.out.println("produce: " + task.no);
                if (newBufSize < cap) {
                    NOT_FULL.signalAll();
                }
            } finally {
                PRODUCE_LOCK.unlock();
            }
            if (newBufSize > 0) {// 如果可以消费通知消费者线程启动
                CONSUME_LOCK.lockInterruptibly();
                try {
                    NOT_EMPTY.signalAll();
                } finally {
                    CONSUME_LOCK.unlock();
                }
            }
        }
    }
    private static class Buffer<E> {
        private Node head;
        private Node tail;
        Buffer() {
            // dummy node
            head = tail = new Node(null);//head和tail的item始终为null，这样可以保证offer和poll时始终不会出现操作同一个元素的情况。
        }
        public void offer(E e) {
            tail.next = new Node(e);
            tail = tail.next;
        }
        public E poll() {
            head = head.next;
            E e = head.item;
            head.item = null;
            return e;
        }
        private class Node {
            E item;
            Node next;
            Node(E item) {
                this.item = item;
            }
        }
    }
    public static void main(String[] args) {
        Model model = new Model4_LockConditionModel2(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
