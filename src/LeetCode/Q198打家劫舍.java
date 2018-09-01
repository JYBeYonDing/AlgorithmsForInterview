package LeetCode;

/**
 * Created by James on 2018/8/31 9:35.
 */
public class Q198打家劫舍 {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i-1]);
        }

        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        Q198打家劫舍 jie = new Q198打家劫舍();
        System.out.println(jie.rob(new int[]{1,2,3,1}));
    }
}
