package 练习;

/**
 * Created by 杨杰 on 2018/7/19 19:50.
 */
public class Main {
    public static void main(String[] args) {
        char res = solution(2, 2);
        System.out.println(res);
    }

    private static char solution(int x, int y) {
        double left = (double) y / (double) x;
        double right = Math.log10(y) / Math.log10(x);
        if (left > right) {
            return '>';
        } else if (left < right) {
            return '<';
        } else {
            return '=';
        }
    }
}
