package 校招2019.TEST;

/**
 * Created by James on 2018/9/9 19:43.
 */
public class Test {

    public static void main(String[] args) {


//        System.out.println(B.c);

        Integer a = 10;
        fun(a);
        System.out.println(a);

    }

    public static void fun(Integer a) {
        a = a * 3;
    }
}

class A{
    public static String c = "C";
    static {
        System.out.println("A");

    }
}


class B extends A{
    static {
        System.out.println("B");
    }

//    public final static String c = "C";
}