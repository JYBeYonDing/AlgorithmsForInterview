import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] onPath;
    boolean result;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        result = true;
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return result;
    }

    private void traverse(List<Integer>[] graph, Integer s) {
        if (onPath[s] == true) {
            result = false;
            return;
        }
        if (visited[s] == true) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge: prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
