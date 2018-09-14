package 校招2019.TEST;

/**
 * Created by James on 2018/9/9 19:45.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(fun1());

    }

    public static String fun1() {
        try {
            System.out.println("A");
            return fun2();
        }finally {

            System.out.println("B");
        }
    }
    public static String fun2() {
        System.out.println("C");
        return "D";
    }
}
