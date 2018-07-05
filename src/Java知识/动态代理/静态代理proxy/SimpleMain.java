package Java知识.动态代理.静态代理proxy;

/**
 * Created by 杨杰 on 2018/6/29 11:35.
 */
public class SimpleMain {
    private static void consume(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name:" + name);
    }
    public static void main(String[] args) {
        consume(new RealObject());
        System.out.println("================================");
        consume(new SimpleProxy(new RealObject()));
    }
}
