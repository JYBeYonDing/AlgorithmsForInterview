package temp;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2021/11/28 22:12
 */
public class Test {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
