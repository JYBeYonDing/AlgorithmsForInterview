package 牛客网.模拟六月场;

import java.util.*;

/**
 * Created by 杨杰 on 2018/6/14 20:09.
 * 又是晴朗的一天，牛牛的小伙伴们都跑来找牛牛去公园玩。
 * 但是牛牛想呆在家里看E3展，不想出去逛公园，可是牛牛又不想鸽掉他的小伙伴们，
 * 于是找来了公园的地图，发现公园是由一个边长为n的正方形构成的，
 * 公园一共有m个入口，但出口只有一个。
 * 公园内有一些湖和建筑，牛牛和他的小伙伴们肯定不能从他们中间穿过，所以只能绕行。
 * 牛牛想知道他需要走的最短距离并输出这个最短距离。

 输入描述:
 第一行输入一个数字n(1≤n≤1000)表示公园的边长
 接下来会给你一个n*n的公园地图，其中 . 表示公园里的道路，@表示公园的入口，*表示公园的出口，#表示公园内的湖和建筑。
 牛牛和他的小伙伴们每次只能上下左右移动一格位置。
 输入保证公园入口个数m(1≤m≤10000)且所有的入口都能和出口相连。
 输出描述:
 输出牛牛需要行走的最短距离。
 示例1
 输入
10
.@....##@.
......#...
...@..#...
###.......
....##..#.
...####...
@...##....
#####.....
..##*####.
#.........
 输出
 16

 感觉自己这种图的搜索算法太差

 考完试后参考推箱子代码写完
 */
public class 牛牛游玩记宽度优先遍历BFS {
    private static class Position {
        int x;
        int y;
        Position pre;
        Position(int x, int y, Position pre) {
            this.x = x;
            this.y = y;
            this.pre = pre;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position)) {
                return false;
            } else {
                Position p = (Position) obj;
                return Objects.equals(this.x, p.x) && Objects.equals(this.y, p.y);
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<Position> enters = new HashSet<>();
        Position exit = null;
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
            for(int j = 0;j<map[i].length;j++) {
                if (map[i][j] == '*') {
                    exit = new Position(i, j,null);
                } else if(map[i][j]=='@') {
                    enters.add(new Position(i, j,null));
                }
            }
        }
        ArrayList<Position> path = bfs(map,exit,enters);
        System.out.println(path.size()-1);
    }

    private static ArrayList<Position> bfs(char[][] map, Position exit, Set<Position> enters) {
        ArrayList<Position> path = new ArrayList<>();// 存放路径结果
        boolean[][] visited = new boolean[map.length][map[0].length];// 标记是否遍历过
        Queue<Position> queue = new LinkedList<>();// 宽度优先遍历用队列
        queue.offer(exit);
        Position end = null;//记录终点，也就是找到的一个路口，因为是从出口开始找起
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            if (enters.contains(cur)) {// 如果是入口中的一个，则说明找到
                end = cur;
                break;
            } else {
                for (int[] dir : dirs) {
                    int tempX = cur.x + dir[0];
                    int tempY = cur.y + dir[1];

                    if (tempX >= 0 && tempX < map.length && tempY >= 0 && tempY < map[0].length
                            && !visited[tempX][tempY] && map[tempX][tempY]!='#') {
                        queue.offer(new Position(tempX, tempY, cur));
                        visited[tempX][tempY] = true;
                    }
                }
            }
        }
        while (end != null) {
            path.add(end);
            end = end.pre;
        }
        return path;
    }
}
