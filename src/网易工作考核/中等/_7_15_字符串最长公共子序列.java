package 网易工作考核.中等;

import java.util.Scanner;
import java.util.Stack;


/**
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
 */
public class _7_15_字符串最长公共子序列 {
    private static int[][] mem;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        mem = new int[s1.length()][s2.length()];
        System.out.println(soulution(s1, s2));
    }

    private static int soulution(String s1, String s2) {
        // dp(s1,i,s2,j) s1[i,...] s2[j,...]的最长公共子序列
        char[] charArray1 = s1.toCharArray();

        char[] charArray2 = s2.toCharArray();


        return dp(charArray1, 0, charArray2, 0);

    }

    private static int dp(char[] charArray1, int i, char[] charArray2, int j) {
        if (i == charArray1.length || j == charArray2.length) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        if (charArray1[i] == charArray2[j]) {
            return 1 + dp(charArray1, i + 1, charArray2, j + 1);
        }else{
            int dp1 = dp(charArray1, i, charArray2, j + 1);
            int dp2 = dp(charArray1, i+1, charArray2, j);
            int dp3 = dp(charArray1, i + 1, charArray2, j + 1);
            return Math.max(Math.max(dp1, dp2), dp3);
        }
    }
}
