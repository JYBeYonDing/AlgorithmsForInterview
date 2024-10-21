package org.example.simple;

import java.util.Scanner;

/**
 * 爬阶梯问题
 * 分数 30
 * 作者 
 * 单位 
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 * 输入格式:
 * 每个测试用例为一行，代表需要到达的楼顶层数n，其中1<=n<=45
 *
 * 输出格式:
 * 对每一组输入，输出可以爬到楼顶的方法数量
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 3
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3
 */
public class Simple26 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int[] dp = new int[n];
        dp[0] = 1;
        //2层时， 2种
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1]  + dp[i - 2];
        }

        System.out.println(dp[n-1]);
    }
}
