package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by James on 2018/8/30 14:22.
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 注意！！！有重复字符
 */
public class Q47全排列2 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        res.add(list);
        while (hasNext(nums)) {
            list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        return res;
    }

    private boolean hasNext(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);

        reverse(nums, i + 1, nums.length - 1);

        return true;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums,start++,end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Q47全排列2 pailie = new Q47全排列2();
        List<List<Integer>> res = pailie.permuteUnique(new int[]{1, 1, 2});

        for (List<Integer> list : res) {

            for (int i : list) {
                System.out.println(i);
            }
            System.out.println();

        }
    }
}
