package 牛客网.网易2017实习生;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/10 18:15.
 * 大家一定玩过“推箱子”这个经典的游戏。
 * 具体规则就是在一个N*M的地图上，
 * 有1个玩家、1个箱子、1个目的地以及若干障碍，其余是空地。
 * 玩家可以往上下左右4个方向移动，但是不能移动出地图或者移动到障碍里去。
 * 如果往这个方向移动推到了箱子，箱子也会按这个方向移动一格，当然，箱子也不能被推出地图或推到障碍里。
 * 当箱子被推到目的地以后，游戏目标达成。现在告诉你游戏开始是初始的地图布局，请你求出玩家最少需要移动多少步才能够将游戏目标达成。
 输入描述:
 每个测试输入包含1个测试用例
 第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
 接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
 每个地图必定包含1个玩家、1个箱子、1个目的地。

 输出描述:
 输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。

 输入例子1:
5 6
......
..*@..
......
.X....
......
6 6
...#..
......
#*##..
..##.#
..X...
.@#...

 输出例子1:
 3
 11

 牛客网上别人的源码
 */
public class 推箱子宽度优先遍历BFS {
    private static class State{
        int px, py, bx, by;
        State pre;

        //状态
        public State(int px, int py, int bx, int by, State pre) {
            this.px = px;//人的位置
            this.py = py;
            this.bx = bx;//箱子的位置
            this.by = by;
            this.pre = pre;//前一个状态
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            int px = -1, py = -1, bx = -1, by = -1;
            char[][] maze = new char[n][];//地图
            for(int i = 0; i < n; i++){
                maze[i] = in.nextLine().toCharArray();
                for(int j = 0; j < m; j++){
                    if(maze[i][j] == 'X'){  //人物坐标
                        px = i;
                        py = j;
                    }else if(maze[i][j] == '*'){   //box坐标
                        bx = i;
                        by = j;
                    }
                }
            }
            State start = new State(px, py, bx, by, null);  //起始状态
            List<State> list = bfs(maze,start);// 宽度优先遍历
            System.out.println(list.size() - 1);
        }
    }

    private static List<State> bfs(char[][] maze, State start){
        int n = maze.length;
        int m = maze[0].length;
        boolean[][][][] added = new boolean[n][m][n][m];   //记录人与箱子的位置，表示这个状态是不是已经遍历过
        Queue<State> queue = new LinkedList<>();// 宽度优先遍历用队列
        LinkedList<State> list = new LinkedList<>();//记录路径
        queue.add(start);
        added[start.px][start.py][start.bx][start.by] = true;// 标记节点已经经过
        int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        State end = null;
        while(!queue.isEmpty()){
            State cur = queue.poll();
            if(maze[cur.bx][cur.by] == '@'){    //判断是否到达终点
                end = cur;// 是终点，找到终点
                break;
            }
            for(int[] a : move){
                State next = new State(cur.px + a[0], cur.py + a[1], cur.bx, cur.by, cur);
                if(next.px == next.bx && next.py == next.by){  //若人与箱子重合，则箱子往前
                    next.bx += a[0];
                    next.by += a[1];
                    if(next.bx < 0 || next.bx >= n || next.by < 0 || next.by >= m || maze[next.bx][next.by] == '#')
                        continue;   //箱子超过边界或遇到障碍
                }else if(next.px < 0 || next.px >= n || next.py < 0 || next.py >= m || maze[next.px][next.py] == '#'){
                    // 若玩家超出边界或进入障碍物
                    continue;
                }
                if(!added[next.px][next.py][next.bx][next.by]){
                    queue.add(next);
                    added[next.px][next.py][next.bx][next.by] = true;
                }
            }
        }
        if(end != null){
            while(end != null){
                list.addFirst(end);
                end = end.pre;
            }
        }
        return list;

    }
}
