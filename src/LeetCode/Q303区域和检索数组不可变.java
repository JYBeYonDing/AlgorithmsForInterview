package LeetCode;

/**
 * Created by 杨杰 on 2018/7/9 20:57.
 */
public class Q303区域和检索数组不可变 {
    private int[] sum = null;
    public Q303区域和检索数组不可变(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i<sum.length;i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }

    public static void main(String[] args) {
        Q303区域和检索数组不可变 obj = new Q303区域和检索数组不可变(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,5));
    }
}
