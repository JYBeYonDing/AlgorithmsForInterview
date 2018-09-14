package LeetCode;

/**
 * Created by James on 2018/9/4 11:44.
 */
public class Q209长度最小的子数组 {




    public int minSubArrayLen(int s, int[] nums) {


        int minLen = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        int tempSum = 0;

        for (; r < nums.length;r++) {
            tempSum += nums[r];

            while (tempSum >= s) {
                minLen = Math.min(minLen, r - l + 1);
                tempSum -= nums[l];
                l++;
            }


        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }


}
