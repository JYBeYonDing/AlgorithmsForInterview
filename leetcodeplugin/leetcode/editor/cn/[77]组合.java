import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, n, k, 1);
        return res;
    }

    public void backtrack(LinkedList<Integer> track, int n, int k, int idx) {
        if (track.size() >= k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = idx; i <= n; i++) {
            track.add(i);
            backtrack(track, n, k, i + 1);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
