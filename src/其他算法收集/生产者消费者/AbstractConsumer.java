package 其他算法收集.生产者消费者;

/**
 * Created by 杨杰 on 2018/6/11 19:13.
 */
public abstract class AbstractConsumer implements Consumer, Runnable {

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
}
