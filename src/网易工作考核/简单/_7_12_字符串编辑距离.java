package 网易工作考核.简单;

import java.util.Scanner;

public class _7_12_字符串编辑距离 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        String word1 = ss[0];
        String word2 = ss[1];
        System.out.println(dp(word1.toCharArray(), word1.length(), word2.toCharArray(), word2.length()));
    }

    private static int dp(char[] word1, int n, char[] word2, int m) {
        int[][] dp = new int[n][m];
        // 边界初始化
        for (int i = 0; i < n; i++) {
            if (word1[i] == word2[0]) {
                dp[i][0] = i;
            } else if (i == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (word1[0] == word2[j]) {
                dp[0][j] = j;
            } else if (j == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1[i] == word2[j]) {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n - 1][m - 1];
    }


    public static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n + 1][m + 1];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            } else if (j != 0) {
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    private static int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }


    /**
     * 字符串编辑距离
     */
    public static class Solution {
        private char[] a;
        private char[] b;
        private int n;
        private int m;
        private int minDist = Integer.MAX_VALUE; // 存储结果

        public Solution(String s1, String s2) {
            this.a = s1.toCharArray();
            this.b = s2.toCharArray();
            this.n = s1.length();
            this.m = s2.length();
        }

        // 调用方式 lwstBT(0, 0, 0);
        public void lwstBT(int i, int j, int edist) {
            if (i == n || j == m) {
                // 如果有一个字符串遍历完了，就将另一个字符串剩下的字符全部删除
                if (i < n) edist += (n - i);
                if (j < m) edist += (m - j);
                if (edist < minDist) minDist = edist;
                return;
            }
            if (a[i] == b[j]) { // 两个字符匹配
                lwstBT(i + 1, j + 1, edist);
            } else { // 两个字符不匹配
                lwstBT(i + 1, j, edist + 1); // 删除a[i]或者b[j]前添加一个字符
                lwstBT(i, j + 1, edist + 1); // 删除b[j]或者a[i]前添加一个字符
                lwstBT(i + 1, j + 1, edist + 1); // 将a[i]和b[j]替换为相同字符
            }
        }


    }


}
