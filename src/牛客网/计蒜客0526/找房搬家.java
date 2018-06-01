package 牛客网.计蒜客0526;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/26 12:24.
 *
 *
 */
public class 找房搬家 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int[] ns = new int[T];
        for (int i = 0; i < T; i++) {
            ns[i] = Integer.parseInt(sc.nextLine());
        }
        init();
        for (int i = 0; i < T; i++) {
            int n = ns[i];
            int max = (n + 1) * 3 * 3 - n;
            int min = dp2[n] - n;
            System.out.println(min+" "+max);
        }
//        solution(ns);

    }

    // 我的思路是找三个相邻的数相乘是n，但是这种做法不对
    private static void solution(int[] ns) {
        int max = 0;
        int min = 0;
        int n = 0;
        for (int i = 0; i < ns.length; i++) {
            n = ns[i];
            max = (n + 1) * 9 - n;
            ArrayList<Integer> abc = findMin(n);
            min = (abc.get(0) + 1) * (abc.get(1) + 2) * (abc.get(2) + 2) - n;

            System.out.println(min + " " + max);
        }
    }
    private static ArrayList<Integer> findMin(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = (int) Math.pow(n, 1.0 / 3)+1; i > 0; i--) {
            if (n % i == 0) {
                a = i;
                break;
            }
        }
        n = n / a;
        for (int i = (int) Math.sqrt(n)+1; i > 0; i--) {
            if (n % i == 0) {
                b = i;
                break;
            }
        }
        c = n / b;
        ArrayList<Integer> abc = new ArrayList<>();
        abc.add(a);
        abc.add(b);
        abc.add(c);
        Collections.sort(abc);
        return abc;
    }


    //群里大佬的解法，直接暴力求解，求i*j*k=n时(i+2)(j+2)(k+1)的最小值。
    //这里为了减少循环层数，分两步计算，先算(i+2)(j+2)=t,再算t*(k+1)
    private static int maxn = (int) 1E6;
    private static int[] dp = new int[maxn+1];
    private static int[] dp2 = new int[maxn+1];

    private static void init() {
        for(int i = 1; i<maxn;i++) {
            dp[i] = dp2[i] = (int)1e9;// 先全部赋最大值
        }
        for(int i = 1;i<=maxn;i++) {
            for(int j=1;i*j<maxn;j++) {
                dp[i * j] = Math.min(dp[i * j], (i + 2) * (j + 2));
            }
        }
        for(int i=1;i<=maxn;i++) {
            for(int j=1;i*j<=maxn;j++) {
                dp2[i * j] = Math.min(dp2[i * j], dp[i] * (j + 1));
            }
        }
    }

}
