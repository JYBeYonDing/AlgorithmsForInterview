package org.example.simple;

import java.util.Scanner;

/**
 * 走格子问题
 * 分数 30
 * 作者 
 * 单位 
 * 一个机器人位于一个m*n网格的左上角 （起始点在下图中标记为 “Start” ）
 *
 * 机器人每次只能向下或者向右移动一步（每个格子只能走一次）
 *
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）
 *
 *
 * 问总共有多少条不同的路径？
 * image.png
 *
 * 输入格式:
 * 每个测试用例输入为一行，用空格隔开，标识为网格的大小，具体形式为：m n
 *
 * 其中，
 *
 * 2<=m<=20
 *
 * 2<=n<=20
 *
 * 输出格式:
 * 对每一组输入，输出路径数量
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 3 3
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 6
 */
public class Simple32 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();

        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[m-1][n-1]);
    }
}
