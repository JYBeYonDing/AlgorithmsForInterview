package 练习;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 杨杰 on 2018/6/18 10:37.
 */
public class 生产者消费者 {
    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public 生产者消费者(int cap) {
        // LinkedBlockingQueue 的队列是 lazy-init 的，但 ArrayBlockingQueue 在创建时就已经 init
        this.queue = new LinkedBlockingDeque<>(cap);
    }

    public Runnable newRunnableConsumer() {
        return new Consumer();
    }

    public Runnable newRunnableProducer() {
        return new Producer();
    }

    public static void main(String[] args) {
        生产者消费者 model = new 生产者消费者(3);
        for(int i=0;i<5;i++) {
            new Thread(model.newRunnableProducer()).start();
        }
        for(int i=0;i<2;i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
    /**
     * 生产者实现类
     */
    private class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
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
    private class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        public void consume() throws InterruptedException {
            Task task = queue.take();// 阻塞等待取成功
            //固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume:" + task.no);
        }
    }

    private class Task {
        public int no;
        public Task(int no) {
            this.no = no;
        }
    }
}
