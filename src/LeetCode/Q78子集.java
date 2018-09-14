package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/9/3 14:57.
 */
public class Q78子集 {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        res.clear();

        LinkedList<Integer> list = new LinkedList<>();
        res.add((List<Integer>) list.clone());

        for (int i = 0; i < nums.length; i++) {
            list.addLast(nums[i]);
            subset(nums, list, i + 1);
            list.removeLast();
        }

        return res;
    }

    // 从index开始
    private void subset(int[] nums, LinkedList<Integer> list, int index) {
        res.add((List<Integer>) list.clone());
        if (index >= nums.length) {
            return;
        }


        for (int i = index; i < nums.length; i++) {
            list.addLast(nums[i]);
            subset(nums, list, i + 1);
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new Q78子集().subsets(new int[]{1, 2, 3});

        for (List<Integer> list : res) {

            for (int i : list) {

                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
