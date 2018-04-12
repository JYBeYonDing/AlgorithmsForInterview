package 牛客网.算法广告课.荷兰国旗问题;

/**
 * Created by 杨杰 on 2018/4/10 21:12.
 * 完成21:26
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 5, 6, 4, 5, 3, 6, 0, 1, 2};
        int partion = 4;
        part(nums, partion);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void part(int[] nums, int partion) {
        int left = -1;
        int right = nums.length;
        for(int i = 0 ; i<right ; ) {
            if (nums[i] < partion) {
                swap(nums, ++left, i++);
            } else if (nums[i] > partion) {
                swap(nums, i, --right);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }
}
