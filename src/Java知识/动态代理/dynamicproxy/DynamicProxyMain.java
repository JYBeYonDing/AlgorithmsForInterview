package Java知识.动态代理.dynamicproxy;

import Java知识.动态代理.静态代理proxy.Interface;
import Java知识.动态代理.静态代理proxy.RealObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 杨杰 on 2018/6/29 11:48.
 */
public class DynamicProxyMain {
    public static void consume(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name:" + name);
    }
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consume(realObject);
        System.out.println("==========================================");

        //动态代理
        ClassLoader classLoader = realObject.getClass().getClassLoader();
        Class<?>[] interfaces = realObject.getClass().getInterfaces();
        InvocationHandler handler = new DynamicProxyHandler(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, interfaces, handler);// 创建一个代理对象

        System.out.println("main方法中：" + proxy.getClass());
        consume(proxy);
    }
}
