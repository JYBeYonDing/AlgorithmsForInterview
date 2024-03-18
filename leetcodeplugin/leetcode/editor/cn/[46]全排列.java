import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        travel(nums, trace, visited);
        return res;
    }

    void travel(int[] nums, LinkedList<Integer> trace, boolean[] visited) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != true) {
                trace.add(nums[i]);
                visited[i] = true;
                travel(nums, trace, visited);
                trace.removeLast();
                visited[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
