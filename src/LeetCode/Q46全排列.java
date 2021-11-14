package LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/30 0:29.
 *
 * 所有元素都不相同
 * 如果有相同元素会有重复，需要去重，可以考虑另一种算法
 */
public class Q46全排列 {

    static List<List<Integer>> res = new ArrayList<>();
    static boolean[] used ;

    public static List<List<Integer>> permute(int[] nums) {

        res.clear();

        used = new boolean[nums.length];
        if (nums.length == 0) {
            return res;
        }


        LinkedList<Integer> p = new LinkedList<>();// 存放每一种排列

        generatePermutation(nums, 0, p);

        return res;
    }


    private static void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        if (index == nums.length) {// 如果遍历到最后了，说明处理完
            LinkedList<Integer> temp = (LinkedList<Integer>) p.clone();// 需要克隆一份，不然始终之后一个对象
            res.add(temp);
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);//回溯
                p.removeLast();// 其他变量恢复原状
                used[i] = false;
            }
        }
    }
}
