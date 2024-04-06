
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int w = sum / 2;
        int n = nums.length;
        // dp[n][w]: 前n个能否装w
        boolean[] dp = new boolean[w + 1];
        // dp[0][w] = false dp[n][0] = true
        dp[0] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = w; j > 0; j--) {
                if (j < nums[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[w];
    }


    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int w = sum / 2;
        int n = nums.length;
        // dp[n][w]: 前n个能否装w
        boolean[][] dp = new boolean[n + 1][w + 1];
        // dp[0][w] = false dp[n][0] = true
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][w];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
