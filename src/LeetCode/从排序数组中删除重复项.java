package LeetCode;

/**
 * Created by 杨杰 on 2018/7/22 14:36.
 */
public class 从排序数组中删除重复项 {
    // 数组完成排序后，我们可以放置两个指针 i和 j，其中 i 是慢指针，而 j 是快指针。
    // 只要 nums[i]=nums[j]，我们就增加 j 以跳过重复项。
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i=0;
        for(int j = 1;j<nums.length;j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    // 复杂度太大
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = nums.length;
        for (int i = 1; i < len; ) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j < len; j++) {
                    nums[j - 1] = nums[j];
                }
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

    }
}
