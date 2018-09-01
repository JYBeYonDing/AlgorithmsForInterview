package 校招2019.腾讯模拟;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/31 18:47.
 */
public class 小Q的歌单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int K = sc.nextInt();

        int A = sc.nextInt();
        int X = sc.nextInt();

        int B = sc.nextInt();
        int Y = sc.nextInt();



        System.out.println(solution(K,A,X,B,Y));;

    }

    private static long solution(int k, int a, int x, int b, int y) {
        if (k == 0) {
            return 0;
        }
        long[][] dp = new long[x + y][k+1];

        int[] songs = new int[x + y];
        for (int i = 0; i < x; i++) {
            songs[i] = a;
        }
        for (int i = x; i < x + y; i++) {
            songs[i] = b;
        }

        if (songs[0] <= k) {// 注意！！！这里很容易遗忘，造成数组越界！！！
            dp[0][songs[0]] = 1;
        }

        for (int i = 0; i < x + y; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + ((j - songs[i]) >= 0 ? dp[i - 1][j - songs[i]] : 0))%1000000007;
            }
        }
        return dp[x + y - 1][k];
    }
}