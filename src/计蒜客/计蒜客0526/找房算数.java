package 计蒜客.计蒜客0526;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/26 12:11.
 * 居然AC过了，纯暴力
 */
public class 找房算数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        int res = 0;
        for(int i = 1; i<=n;i++) {
            for(int j=1;j<=n;j++) {
                int fi = f(i);
                int fj = f(j);
                if (fi * fj > 0 && gcd(fi, fj) <= k) {
                    res++;
                }
            }
        }
        return res;
    }
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
    private static int f(int n) {
        String sn = n + "";
        int tmp = 1;
        for(int i = 0 ; i<sn.length();i++) {
            tmp *= sn.charAt(i) - '0';
        }
        return tmp;
    }
}
