package LeetCode;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2022/9/14 21:52
 */
public class Q27移除元素 {
    public static void main(String[] args) {
        int i = removeElement(new int[]{1, 1, 1,2,2},1);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
