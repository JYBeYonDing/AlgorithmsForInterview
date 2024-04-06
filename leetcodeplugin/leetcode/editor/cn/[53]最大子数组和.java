import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dp;
    public int maxSubArray(int[] nums) {
        dp = new int[nums.length];
        dp[0] = Math.max(Integer.MIN_VALUE, nums[0]);
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
