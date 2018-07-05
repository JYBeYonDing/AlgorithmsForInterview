package 其他算法收集;

/**
 * Created by 杨杰 on 2018/7/5 12:09.
 */
public class 最大公约数最小公倍数 {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        System.out.println("最大公约数");
        System.out.println(gcd(n,m));
        System.out.println("最小公倍数");
        System.out.println(lcm(n,m));
    }

    /**
     * 最大公约数 Greatest Common Divisor
     * 辗转相除法
     */
    private static int gcd(int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }

    /**
     * 最小公倍数 lowest common multiple
     * 需要用到最大公约数
     */
    private static int lcm(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        return n * m / gcd(n, m);
    }
}
