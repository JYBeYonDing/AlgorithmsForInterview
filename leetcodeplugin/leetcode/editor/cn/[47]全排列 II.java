import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> track = new LinkedList<>();

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int idx) {
        if (track.size() >= nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, i + 1);
            track.removeLast();
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
