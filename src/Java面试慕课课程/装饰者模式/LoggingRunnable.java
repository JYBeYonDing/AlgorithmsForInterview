package Java面试慕课课程.装饰者模式;

/**
 * Created by 杨杰 on 2018/6/25 21:43.
 */
public class LoggingRunnable implements Runnable {
    private final Runnable innerRunnable;
    public LoggingRunnable(Runnable innerRunnable) {
        this.innerRunnable = innerRunnable;
    }
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Task started at " + startTime);
        innerRunnable.run();
        System.out.println("Task finished. Elapsed time " + (System.currentTimeMillis() - startTime));
    }
}
