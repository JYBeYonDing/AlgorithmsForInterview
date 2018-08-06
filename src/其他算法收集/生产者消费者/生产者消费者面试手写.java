package 其他算法收集.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 杨杰 on 2018/6/21 19:53.
 */
public class 生产者消费者面试手写 {
    //阻塞队列实现，设为final不可变
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
    public static void main(String[] args) {
        生产者消费者面试手写 生产者消费者 = new 生产者消费者面试手写();
        new Thread(生产者消费者.new Producer()).start();
        new Thread(生产者消费者.new Consumer()).start();
        new Thread(生产者消费者.new Producer()).start();
        new Thread(生产者消费者.new Consumer()).start();
    }
    //⽣产者线程
    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1); //向队列⾥加元素
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take(); //从队列取元素
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
