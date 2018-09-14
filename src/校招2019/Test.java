package 校招2019;

/**
 * Created by James on 2018/9/4 19:10.
 */
public class Test {


    public static void main(String[] args) {

        System.out.println(Test2.a);

    }
}

class Test2{
    static {
        System.out.println("OK");
    }
    public static final String a = new String("JD");
}

