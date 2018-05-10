package 牛客网.网易2017实习生;

import java.util.*;

/**
 * Created by 杨杰 on 2018/5/10 20:47.
 * 输入例子1:
 * 4 4
 * ....
 * ..*@
 * ....
 * .X..
 * <p>
 * 6 6
 * ...#..
 * ......
 * #*##..
 * ..##.#
 * ..X...
 * .@#...
 * <p>
 * 输出例子1:
 * 3
 * 11
 * BFS
 *  . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
 */
public class 推箱子2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
//        System.out.println(s);
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
        char[][] maze = new char[N][M];
        int px=-1, py=-1, bx=-1, by=-1;
//        System.out.println("N"+N+"M"+M);
        for (int i = 0; i < N; i++) {
            maze[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == '*') {
                    bx = i;
                    by = j;
                } else if (maze[i][j] == 'X') {
                    px = i;
                    py = j;
                }
            }
        }
        if (px == -1 || bx == -1) {
            System.out.println(-1);
        } else {
            State start = new State(px, py, bx, by,null);
            ArrayList<State> path = solute(start, maze);
            System.out.println(path.size()==0?-1:path.size());
        }
    }

    // 相当于在4维空间进行宽度优先遍历
    private static ArrayList<State> solute(State start, char[][] maze) {
        ArrayList<State> path = new ArrayList<>();// 存放路径
        Queue<State> queue = new LinkedList<>();// 宽度优先遍历需要队列
        boolean[][][][] hasReached = new boolean[maze.length][maze[0].length][maze.length][maze[0].length];//记录已经到达过的状态
        hasReached[start.personX][start.personY][start.boxX][start.boxY] = true;
        queue.add(start);
        // 四个方向 x,y
        int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        State cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
//            int px = cur.personX;
//            int py = cur.personY;
//            int bx = cur.boxX;
//            int by = cur.boxY;
            if (maze[cur.boxX][cur.boxY] == '@') {// 到达目的地
                break;
            }
            for (int[] d : directs) {
                int bx = cur.boxX;
                int by = cur.boxY;
                int px = cur.personX + d[0];
                int py = cur.personY + d[1];
                if (px < 0 || px >= maze.length || py < 0 || py >= maze[0].length || maze[px][py]=='#') {
                    // 如果越界了
                    continue;
                } else {// 说明没有越界
                    if (px==bx && py==by) {
                        // 如果玩家来到箱子上，则箱子也要延同样方向移动
                        bx = cur.boxX + d[0];
                        by = cur.boxY + d[1];
                        if (bx < 0 || bx >= maze.length || by < 0 || by >= maze[0].length || maze[bx][by] == '#') {
                            // 说明箱子越界了
                            continue;
                        }

                    }
                }
                if (!hasReached[px][py][bx][by]) {
                    hasReached[px][py][bx][by] = true;
                    queue.add(new State(px, py, bx, by,cur));
                }
            }
        }
        if (maze[cur.boxX][cur.boxY] == '@') {
            //说明找到路径
            while (cur.pre != null) {
                path.add(cur);
                cur = cur.pre;
            }
        }
        return path;
    }

    private static class State {
        int personX,personY,boxX, boxY;
        State pre;
        public State(int px, int py, int bx, int by, State pre) {
            this.personX = px;
            this.personY = py;
            this.boxX = bx;
            this.boxY = by;
            this.pre = pre;
        }
    }
}
