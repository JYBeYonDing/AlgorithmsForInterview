import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums, 0);
        return res;
    }

    public void backtrack(LinkedList<Integer> track, int[] nums, int idx) {
        res.add(new ArrayList<>(track));
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(track, nums, i + 1);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
