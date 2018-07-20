package 其他算法收集.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 杨杰 on 2018/6/11 20:09.
 * BlockingQueue实现生产者消费者模式
 */
public class Model1_BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public Model1_BlockingQueueModel(int cap) {
        // LinkedBlockingQueue 的队列是 lazy-init 的，但 ArrayBlockingQueue 在创建时就已经 init
        this.queue = new LinkedBlockingQueue<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }


    //*****************************************************************
    /**
     * 生产者实现类
     */
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);// 阻塞等待存成功
            System.out.println("produce:" + task.no);
        }
    }

    /**
     * 消费者实现类
     */
    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();// 阻塞等待取成功
            //固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume:" + task.no);
        }
    }


    //*****************************************************************************
    public static void main(String[] args) {
        Model model = new Model1_BlockingQueueModel(3);
        for(int i=0;i<5;i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for(int i=0;i<2;i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
