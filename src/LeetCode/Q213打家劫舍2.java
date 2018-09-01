package LeetCode;

/**
 * Created by James on 2018/9/1 12:32.
 *
 * 由于是一个环形，所以需要考虑到第一个和最后一个，然后可以分两种情况来用动态规划。
 * 第一种为第一家偷的情况下，最大盗取金额，第二种为第一家不偷的情况下最大盗取金额。取二者最大值即为本题答案。
 */
public class Q213打家劫舍2 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];

        dp1[0] = nums[0];
        dp2[0] = nums[1];

        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length-1; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], nums[i + 1] + dp2[i - 2]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);

    }

    public static void main(String[] args) {
        Q213打家劫舍2 dajia = new Q213打家劫舍2();

        System.out.println(dajia.rob(new int[]{0,0}));
    }

}

