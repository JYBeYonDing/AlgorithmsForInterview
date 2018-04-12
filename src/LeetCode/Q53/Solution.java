package LeetCode.Q53;

/**
 * Created by 杨杰 on 2018/4/9 22:29.
 */
public class Solution {
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int ans = -100000;
        for(int i = 0 ; i< n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += nums[j];
                if(sum > ans){
                    ans = sum;
                }
            }
        }

        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i< n ; i++){

            sum += nums[i];
            if(sum > ans){
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;
            }

        }

        return ans;
    }


}
