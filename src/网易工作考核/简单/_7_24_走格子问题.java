package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 一个机器人位于一个m*n网格的左上角 （起始点在下图中标记为 “Start” ）
 *
 * 机器人每次只能向下或者向右移动一步（每个格子只能走一次）
 *
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）
 *
 *
 * 问总共有多少条不同的路径？
 */
public class _7_24_走格子问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }


        System.out.println(dp[n - 1][m - 1]);
    }


}
