package LeetCode;

/**
 * Created by James on 2018/8/31 11:30.
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        String m = "ABCDEG";
        String n = "AEBDFE";

        char[] ms = m.toCharArray();
        char[] ns = n.toCharArray();

//        int[][] memo = new int[ms.length][ns.length];
//
//        System.out.println(lcs(ms, ns, ms.length - 1, ns.length - 1,memo));
//

        // 动态规划
        System.out.println(solution(ms, ns));



    }


    // 动态规划
    private static int solution(char[] ms, char[] ns) {

        int[][] dp = new int[ms.length+1][ns.length+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (ms[i - 1] == ns[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ms.length][ns.length];

    }



    // 递归
    private static int lcs(char[] ms, char[] ns, int mindex, int nindex, int[][] memo) {

        if (mindex == -1 || nindex == -1) {
            return 0;
        }

        if (memo[mindex][nindex] != 0) {
            return memo[mindex][nindex];
        }
        if (ms[mindex] == ns[nindex]) {
            memo[mindex][nindex] = 1 + lcs(ms, ns, mindex - 1, nindex - 1, memo);
            return memo[mindex][nindex];
        } else {
            memo[mindex][nindex]=Math.max(lcs(ms, ns, mindex - 1, nindex,memo), lcs(ms, ns, mindex, nindex - 1,memo));
            return memo[mindex][nindex];
        }
    }


}
