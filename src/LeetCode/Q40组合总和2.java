package LeetCode;

import java.util.*;

/**
 * Created by James on 2018/8/30 15:35.
 */
public class Q40组合总和2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();

        Arrays.sort(candidates);

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


        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            } else {
                sum += candidates[i];
                if (sum <= target) {
                    oneCom.addLast(candidates[i]);
                    combinate(candidates, i + 1, oneCom, target, sum);
                    oneCom.removeLast();
                }
                sum -= candidates[i];

            }
        }
    }


    public static void main(String[] args) {
        Q40组合总和2 zuhe = new Q40组合总和2();
        List<List<Integer>> res = zuhe.combinationSum2(new int[]{2,5,2,1,2}, 5);

        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

}
