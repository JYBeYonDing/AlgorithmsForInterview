package Java知识.动态代理.静态代理proxy;

/**
 * Created by 杨杰 on 2018/6/29 11:33.
 */
public class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void getMyName() {
        System.out.print("静态代理proxy getmyname ");
        proxied.getMyName();
    }

    @Override
    public String getNameById(String id) {
        System.out.print("静态代理proxy getnamebyid ");
        return proxied.getNameById(id);
    }
}
