package 校招2019.美丽联合;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/27 19:39.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(solution(m, n));
    }

    public static int solution(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}