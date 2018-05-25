import java.io.UnsupportedEncodingException;

/**
 * 临时测试用，可以清空
 * 用于进行一些编程的测试，每次要用时可以将这里的内容清空
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, CloneNotSupportedException {
        new Test().clone();
        System.out.println(new String("c3VuY2hhb2ZlaUBkaWRpY2h1eGluZy5jb20=".getBytes("iso-8859-1"), "utf-8"));

        
    }
}
