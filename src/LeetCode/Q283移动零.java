package LeetCode;

/**
 * Created by James on 2018/9/3 23:12.
 */
public class Q283移动零 {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int k = 0;// [0,k)的元素均为非0元素

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }



    //***************************************************************
    public void moveZeroes2(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int k = 0;// [0,k)的元素均为非0元素

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != k) {
                swap(nums, i, k++);
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
