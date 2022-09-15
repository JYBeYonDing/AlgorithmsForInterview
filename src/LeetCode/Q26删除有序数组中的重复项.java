package LeetCode;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2022/9/14 21:52
 */
public class Q26删除有序数组中的重复项 {
    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 1});
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1 || nums.length==0) {
            return nums.length;
        }
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                nums[++pre]=nums[i];
            }
        }
        return pre+1;

    }
}
