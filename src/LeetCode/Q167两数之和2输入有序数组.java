package LeetCode;

/**
 * Created by James on 2018/9/4 11:11.
 */
public class Q167两数之和2输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else {
                if (numbers[l] + numbers[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new int[]{-1, -1};

    }

}
