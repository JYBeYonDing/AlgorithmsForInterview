package 其他算法收集.生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 杨杰 on 2018/6/11 21:00.
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
 */
public class Model3_LockConditionModel1 implements Model {
    private final Lock BUFFER_LOCK = new ReentrantLock();// 可重入锁
    //    private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private final Condition p = BUFFER_LOCK.newCondition();
    private final Condition c = BUFFER_LOCK.newCondition();
    private final Queue<Task> buffer = new LinkedList<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public Model3_LockConditionModel1(int cap) {
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

    //************************************************************************************

    /**
     * 生产者实现类
     */
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            //不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (buffer.size() == cap) {
                    p.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("produce:" + task.no);
                c.signalAll();
            }finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    /**
     * 消费者实现类
     */
    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (buffer.size() == 0) {
                    c.await();
                }
                Task task = buffer.poll();
                assert task != null;
                //固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) Math.random() * 500);
                System.out.println("consume:" + task.no);
                p.signalAll();
            }finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    //**************************************************************************************
    public static void main(String[] args) {
        Model model = new Model3_LockConditionModel1(3);
        for(int i=0;i<5;i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for(int i=0;i<2;i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }

}
