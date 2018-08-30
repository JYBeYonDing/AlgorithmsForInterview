package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 2018/8/30 9:45.
 */
public class Q77组合 {

    static ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (k <= 0 || n <= 0 || k>n) {
            return res;
        }

        LinkedList<Integer> p = new LinkedList<>();

        findCombinations(n, 1, k, p);

        return res;
    }

    private void findCombinations(int n, int start, int k, LinkedList<Integer> p) {
        if (k == p.size()) {
            LinkedList<Integer> temp = (LinkedList<Integer>) p.clone();
            res.add(temp);
            return;
        }
        if (start >= n + 1) {
            return;
        }

        for (int i = start; i <= n-(k-p.size())+1; i++) {
            p.addLast(i);
            findCombinations(n, i + 1, k, p);
            p.removeLast();
        }
    }
}
