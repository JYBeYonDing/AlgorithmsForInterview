package 校招2019.海康;

/**
 * Created by James on 2018/9/8 19:39.
 */
public class ThreadLock {
    public static void main(String[] args) {
        ThreadLock test = new ThreadLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test.method2();
                test.method3();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        // 注意，这里可能会有个随机性，可以用插入时延进行验证
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.method1();
    }

    public synchronized void method1() {
        try {
            Thread.sleep(1000);
            System.out.println("call method1");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println("call method2");

    }

    public synchronized void method3() {
        System.out.println("call method3");
    }

}
