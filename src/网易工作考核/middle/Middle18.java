package org.example.middle;

import java.util.Scanner;

/**
 * 字符串最长公共子序列
 * 分数 30
 * 作者
 * 单位
 * 假设你正在使用一款版本控制系统，这款系统使用两个字符串A和B来表示两个版本内容。这两个字符串的长度都不超过1000。你的任务是计算出这两个版本之间的最长公共子序列长度，以便更好地理解这两个版本之间的差异。请注意，子序列的字符不需要在原始字符串中连续。
 *
 *
 * 例如，假设输入两个版本，其内容分别为 "abcfbcab" 和 "bdcabdfcab"，那么 "bca" 是一个公共子序列，"abcab" 也是一个公共子序列，其中 "abfcab" 是这两个版本之间的最长公共子序列，输出的长度为6
 *
 *
 * 输入格式:
 * 第1行：表示第一个版本代码文件的字符串
 *
 * 第2行：表示第二个版本代码文件的字符串
 *
 * 输出格式:
 * 输出这两个版本的最长公共子序列长度
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * abcfbcab
 * bdcabdfcab
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 6
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * ABCBDAB
 * BDCAB
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 4
 */
public class Middle18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        in.close();

        int al = a.length();
        int bl = b.length();

        //多一行列，代表无字符的公共子串数量，都是0
        int[][] dp = new int[al + 1][bl + 1];

        //都增加一个字符(+1);,或只有一边增加一个字符(不变)
        //dp[i][j] = dp[i-1][j-1] + 1 || max(dp[i][j-1],dp[i-1][j])
        for(int i = 1; i <= al; i++) {
            for(int j = 1; j <= bl; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[al][bl]);
    }
}
