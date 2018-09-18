package 校招2019.招银信用卡;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/16 19:48.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();


        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1] = 1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}