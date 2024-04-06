import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<Integer>[] graph = null;

    boolean[] visited;

    boolean[] onPath;

    List<Integer> path = new ArrayList<>();

    int[] result;

    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }

        if (hasCycle) {
            return new int[] {};
        }
        Collections.reverse(path);
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = path.get(i);
        }
        return result;
    }

    private void traverse(int node) {
        if (onPath[node]) {
            // 存在环
            hasCycle = true;
            return;
        }
        if (visited[node]) {
            return;
        }
        onPath[node] = true;
        visited[node] = true;
        ArrayList<Integer> nextList = graph[node];
        if (nextList != null) {
            for (int i: nextList) {
                traverse(i);
            }
        }
        path.add(node);
        onPath[node] = false;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int[] prerequisite: prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            if (graph[from] == null) {
                graph[from] = new ArrayList<Integer>();
            }
            graph[from].add(to);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
