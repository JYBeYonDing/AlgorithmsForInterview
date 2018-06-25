package 其他算法收集.生产者消费者.一个类中;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 杨杰 on 2018/6/21 19:48.
 */
public class Test2 {
    private static Integer count = 0; // 缓冲区
    private final Integer FULL = 5;
    final Lock lock = new ReentrantLock(); // 可重⼊锁
    final Condition put = lock.newCondition();
    final Condition get = lock.newCondition();

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
    }

    // ⽣产者
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();// 获得锁
                try {
                    while (count == FULL) {// 如果已经⽣产满
                        try {
                            put.await();// ⽣产者等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;// 没有⽣产满，继续⽣产
                    System.out.println("⽣产者 " +
                            Thread.currentThread().getName() + "已⽣产，商品 数量:" + count);
                    get.signal();// 通知消费者可以消费
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) { // 没有可以消费的东⻄时，消费者需要等待
                        try {
                            get.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;// 有消费的东⻄
                    System.out.println("消费者 " +
                            Thread.currentThread().getName() + "已经消费,剩余 商品数量:" + count);
                    put.signal();// 通知⽣产者可以⽣产
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
