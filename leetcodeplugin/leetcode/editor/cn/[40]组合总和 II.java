import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> track = new LinkedList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i + 1);
            track.removeLast();
            sum -= candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
