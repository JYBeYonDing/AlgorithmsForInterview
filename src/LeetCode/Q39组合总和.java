package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/30 15:20.
 */
public class Q39组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();

        LinkedList<Integer> oneCom = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int sum = 0;
        combinate(candidates, 0, oneCom, target, sum);
        return res;
    }

    private void combinate(int[] candidates, int index, LinkedList<Integer> oneCom, int target, int sum) {
        if (sum == target) {
            //保存记录
            res.add((List<Integer>) oneCom.clone());
            return;
        }
        if (index == candidates.length) {
            return;
        }

        //选index
        sum = sum + candidates[index];
        if (sum <= target) {
            oneCom.addLast(candidates[index]);
            combinate(candidates, index, oneCom, target, sum);
            oneCom.removeLast();
        }
        //不选index
        sum = sum - candidates[index];
        combinate(candidates, index + 1, oneCom, target, sum);
    }


    public static void main(String[] args) {
        Q39组合总和 zuhe = new Q39组合总和();
        List<List<Integer>> res = zuhe.combinationSum(new int[]{2, 3, 6, 7}, 7);

        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}
