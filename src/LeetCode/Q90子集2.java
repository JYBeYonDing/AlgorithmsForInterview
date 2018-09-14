package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/9/3 15:18.
 */
public class Q90子集2 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.clear();
        if (nums == null) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();

        res.add(list);

        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                list.addLast(nums[i]);
                subsets(nums, i + 1, list);
                list.removeLast();
            }
        }

        return res;
    }

    private void subsets(int[] nums, int index, LinkedList<Integer> list) {
        res.add((List<Integer>) list.clone());
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (i==index || nums[i] != nums[i - 1]) {
                list.addLast(nums[i]);
                subsets(nums, i + 1, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Q90子集2().subsetsWithDup(new int[]{1, 2, 2});

        for (List<Integer> list : res) {

            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
    }

}
