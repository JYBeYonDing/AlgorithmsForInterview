import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }

    private void backtrace(int[] candidates, int target, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            sum += candidates[i];
            trace.add(candidates[i]);
            backtrace(candidates, target, i);
            sum -= candidates[i];
            trace.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
