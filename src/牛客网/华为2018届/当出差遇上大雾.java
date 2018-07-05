package 牛客网.华为2018届;

import java.util.*;

/**
 * Created by 杨杰 on 2018/6/27 20:42.
 * https://blog.csdn.net/Jacky_chenjp/article/details/73433824
 * 没有做出来
 */
public class 当出差遇上大雾 {
    static final int M = 1000;
    public static void main(String[] args) {
        int[][] map = {{0, 2, 10, 5, 3, M},
                {M, 0, 12, M, M, 10},
                {M, M, 0, M, 7, M},
                {2, M, M, 0, 2, M},
                {4, M, M, 1, 0, M},
                {3, M, 1, M, 2, 0}};

        int x = 2;
        int y = 4;
        solution(map, x-1, y-1);
    }

    // DFS，深度优先遍历，找出所有可能路径的过程中保留下距离最短的
    private static void solution(int[][] map, int x, int y) {
        final int from = 5-1;// 起始点5号城市，索引为4
        if (y >= 0) {
            for(int i = 0; i<map.length;i++) {
                map[i][y] = M;
                map[y][i] = M;
            }
            map[y][y] = 0;
        }
        boolean[] visited = new boolean[map.length];// 当前城市是否访问过
        ArrayList<Integer> minPath = null;
        int minLength = Integer.MAX_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();// 深度优先遍历用到的栈
        stack.push(from);
        int tempPathLen = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for(int next = 0;next<map.length ;next++) {
                if (next != cur && !visited[next]) {
                    if (map[cur][next] < M) {// 如果是有路的
                        tempPathLen += map[cur][next];
                        stack.push(cur);
                        stack.push(next);
                        visited[next] = true;
                        if (next == x && tempPathLen < minLength) {// 如果找到更短的路径
                            minLength = tempPathLen;
                            minPath = new ArrayList<>();
                            for(int i=stack.size()-1;i>=0;i--) {
                                minPath.add(stack.get(i));
                            }
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(minLength);
        for (int i : minPath) {
            System.out.print(i+1+" ");
        }
    }

}
