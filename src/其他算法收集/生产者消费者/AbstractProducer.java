package 其他算法收集.生产者消费者;

/**
 * Created by 杨杰 on 2018/6/11 19:14.
 */
public abstract class AbstractProducer implements Producer, Runnable {
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
}
