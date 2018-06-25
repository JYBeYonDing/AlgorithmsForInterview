package 其他算法收集.生产者消费者.一个类中;

/**
 * Created by 杨杰 on 2018/6/21 19:42.
 */
public class Test {
    private static Integer count = 0;
    private final Integer FULL = 5;
    private static String lock = "lock";

    public static void main(String[] args) {
        Test test1 = new Test();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }
    // ⽣产者线程
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {// 应该是为true的，这里只是不让程序一直执行下去
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) { // ⽣产满了
                        try {
                            lock.wait(); // 停⽌⽣产
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 没有⽣产满，就⽣产
                    count++;
                    System.out.println("⽣产者 ： "
                            + Thread.currentThread().getName() + "已⽣产,商品数量 ： " + count);
                    lock.notifyAll();// 通知消费者线程可以消费
                }
            }
        }
    }

    // 消费者线程
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) { // 获得锁
                    while (count == 0) { // 没有可以消费的了
                        try {
                            lock.wait(); // 就等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--; // 有可以消费的，就继续消费
                    System.out.println("消费者： " + Thread.currentThread().getName() + "已消费，剩余 产品数量： " + count);
                    lock.notify();// 通知⽣产者继续⽣产
                }
            }
        }
    }
}
