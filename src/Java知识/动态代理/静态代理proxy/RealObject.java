package Java知识.动态代理.静态代理proxy;

/**
 * Created by 杨杰 on 2018/6/29 11:26.
 */
public class RealObject implements Interface {
    @Override
    public void getMyName() {
        System.out.println("my name is hh");
    }

    @Override
    public String getNameById(String id) {
        System.out.println("argument id:"+id);
        return "hh";
    }
}
