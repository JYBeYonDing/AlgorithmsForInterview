package 其他算法收集.单例模式;

/**
 * Created by 杨杰 on 2018/8/6 23:56.
 * 单例模式：构造函数一定要私有化
 */


class Singleton懒汉 {
    private static Singleton懒汉 instance;
    //注意！！！构造函数一定要私有化
    private Singleton懒汉(){}
    public static synchronized Singleton懒汉 getInstance() {
        if (instance == null) {
            instance = new Singleton懒汉();
        }
        return instance;
    }
}


class Singleton饿汉 {
    private static Singleton饿汉 instance = new Singleton饿汉();
    //注意！！！构造函数一定要私有化
    private Singleton饿汉(){}
    public static Singleton饿汉 getInstance() {
        return instance;
    }
}

class Singleton双检锁 {
    private volatile static Singleton双检锁 singleton;
    //注意！！！构造函数一定要私有化
    private Singleton双检锁(){}
    public static Singleton双检锁 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton双检锁.class) {
                if (singleton == null) {
                    singleton = new Singleton双检锁();
                }
            }
        }
        return singleton;
    }
}


class Singleton静态内部类 {
    private static class SingletonHolder {
        private static final Singleton静态内部类 INSTANCE = new Singleton静态内部类();
    }
    private Singleton静态内部类(){}
    public static final Singleton静态内部类 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

//枚举方法实现单例模式
enum Singleton枚举 {
    INSTANCE;
    public void whateverMethod() {
    }
}