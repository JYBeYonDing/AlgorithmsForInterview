package LeetCode;

/**
 * Created by James on 2018/8/31 12:22.
 */
public class Q416分割等和子集 {

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 == 1) {
            return false;
        }

        return solution(nums, sum / 2);
    }

    private boolean solution(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum + 1];// 思考到第i个数据的时候，能够填满sum=j

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = (j == nums[0]);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] || (j>=nums[i] && dp[i - 1][j - nums[i]]);
            }
        }


        return dp[nums.length - 1][sum];
    }


}
