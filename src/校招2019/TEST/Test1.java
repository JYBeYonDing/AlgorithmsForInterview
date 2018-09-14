package 校招2019.TEST;

/**
 * Created by James on 2018/9/13 10:29.
 */
public class Test1 {
    static int x =10;
    static {x+=5;}
    public static void main(String[] args) {
        System.out.println("x" + x);



    }
    static {x/=3;}
}
