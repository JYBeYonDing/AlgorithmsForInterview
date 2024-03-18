//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n == 0 || n == 1) {
            return n;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];



//        int[] dp = new int[n + 1];
//        dp(dp, n);
//        return dp[n];
    }

    public int dp(int[] dp, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            dp[n] = 1;
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = dp(dp, n - 1) + dp(dp, n - 2);
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
