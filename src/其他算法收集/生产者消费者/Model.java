package 其他算法收集.生产者消费者;

/**
 * Created by 杨杰 on 2018/6/11 19:15.
 * 不同的模型实现中，生产者、消费者的具体实现也不同，所以需要为模型定义抽象工厂方法
 */
public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
