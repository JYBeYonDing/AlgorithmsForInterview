package 其他算法收集.生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 杨杰 on 2018/6/11 20:39.
 */
public class Model2_WaitNotifyModel implements Model {
    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public Model2_WaitNotifyModel(int cap) {
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

    //*********************************************************************

    /**
     * 生产者实现类
     */
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            //不定期生产，模拟随机的用户请求
            Thread.sleep((long) Math.random() * 1000);
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == cap) {
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("produce:" + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    /**
     * 消费者实现类
     */
    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == 0) {
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume:" + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    //**********************************************************************************
    public static void main(String[] args) {
        Model model = new Model2_WaitNotifyModel(3);
        for(int i=0;i<5;i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for(int i=0;i<2;i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }

}
