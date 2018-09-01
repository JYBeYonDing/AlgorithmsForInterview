package LeetCode;

/**
 * Created by 杨杰 on 2018/4/9 20:43.
 */
class Q198 {
    public static int[] res;

    public int solve(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }
        if (res[idx] > -1) {
            return res[idx];
        }
        res[idx] = Math.max(nums[idx] + solve(idx - 2, nums),
                solve(idx - 1, nums));

        return res[idx];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int idx = 2; idx < nums.length; idx++) {
            res[idx] = Math.max(nums[idx] + res[idx - 2], res[idx - 1]);
        }

        return res[nums.length - 1];
    }
}
