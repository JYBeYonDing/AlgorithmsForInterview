package LeetCode;

/**
 * Created by James on 2018/8/31 11:06.
 *
 * 如果想要找到具体的子序列，可以从最后长度表为最大的数开始往前找，找到长度小1，并且值比后面的值小的数即可为前一个数。
 */
public class Q300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = maxlength(nums, dp, i);
        }

        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private int maxlength(int[] nums, int[] dp, int index) {
        int res = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < nums[index]) {
                res = Math.max(res, dp[i]+1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Q300最长上升子序列 xulie = new Q300最长上升子序列();
        System.out.println(xulie.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
