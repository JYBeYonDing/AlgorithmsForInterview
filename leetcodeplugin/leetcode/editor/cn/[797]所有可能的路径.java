import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    HashSet<Integer> visited = new HashSet<>();

    LinkedList<Integer> path = new LinkedList<>();

    int n = 0;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        traverse(graph, 0);
        return result;
    }

    public void traverse(int[][] graph, int node) {
        if (visited.contains(node)) {
            return;
        }
        path.add(node);
        if (node == n - 1) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int i : graph[node]) {
            traverse(graph, i);
        }
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
