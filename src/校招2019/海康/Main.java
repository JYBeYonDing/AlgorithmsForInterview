package 校招2019.海康;

/**
 * Created by James on 2018/9/8 19:45.
 */
public class Main {
    public static void main(String[] args) {
        int index = 40;

        long a=1;
        long b=1;

        for (int i = 3; i <= index; i++) {
            b = a + b;
            a = b - a;
        }
        System.out.println(b);
    }
}
