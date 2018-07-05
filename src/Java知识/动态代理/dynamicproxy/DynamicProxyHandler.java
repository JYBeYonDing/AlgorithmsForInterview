package Java知识.动态代理.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by 杨杰 on 2018/6/29 11:39.
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        System.out.println("动态代理处理器构造器:" + proxied.getClass());
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invokeObject = method.invoke(proxied, args);// 调用proxied对象的method方法
        if (invokeObject != null) {
            System.out.println("调用返回值类型为：" + invokeObject.getClass());
        } else {
            System.out.println("调用的返回值类型为null");
        }
        return invokeObject;// 返回调用函数的返回值
    }
}
