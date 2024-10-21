package org.example.simple;

import java.util.Scanner;

/**
 * 字符串编辑距离
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个源串和目标串，能够对源串进行如下操作：
 *
 * 在给定位置上插入一个字符
 *
 * 替换任意字符
 *
 * 删除任意字符
 *
 * 写一个程序，返回最小操作数，使得对源串进行这些操作后等于目标串
 *
 * 输入格式:
 * 函数的输入是一行包含两个字符串，word1 和 word2，以空格分割
 *
 * 每个字符串的长度大于0同时小于500，word1 和 word2 由小写英文字母组成
 *
 * 输出格式:
 * 输出两个字符的编辑距离，是一个整数
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * horse ros
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 3
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * intention execution
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 5
 */
public class Simple15 {

    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String[] wd = in.nextLine().split(" ");
        in.close();

        String w1 = wd[0];
        String w2 = wd[1];

        int w1l = w1.length();
        int w2l = w2.length();

        int[][] dp = new int[w1l + 1][w2l + 1];

        for(int i = 0; i <= w1l; i++) {
            dp[i][0] = i;
        }

        for(int i = 0; i <= w2l; i++) {
            dp[0][i] = i;
        }

        //动态规划
        for(int i = 1; i <= w1l; i++) {
            char c1 = w1.charAt(i -1);
            for(int j = 1; j <= w2l; j++) {
                char c2 = w2.charAt(j -1);
                if(c1 == c2) {
                    //相等时
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                //不相等时
                dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1;
            }
        }

        System.out.println(dp[w1l][w2l]);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a,b),c);
    }
}
