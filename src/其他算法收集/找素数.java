package 其他算法收集;

/**
 * Created by 杨杰 on 2018/5/17 20:57.
 */
public class 找素数 {
    // 方法一
    public static void main(String[] args) {
        printPrime(100);
    }

    private static void printPrime(int n) {
        for (int i = 2; i < n; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (j == i & count == 1) {
                    System.out.print(i + " ");
                }
                if (count > 1) {
                    break;
                }
            }
        }
    }

    /**
     * 方法二
     */
    public static void main2(String[] args) {

        for (int j = 2; j < 1000; j++) {
            if (m(j)) {
                System.out.print(j + " ");
            }
        }
    }

    public static boolean m(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
