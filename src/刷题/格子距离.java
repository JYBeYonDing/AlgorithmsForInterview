package 刷题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/7/5 22:47.
 * 有一个n*m的格子图，每个格子最多与其周围的四个相邻，不相邻的格子之间互相不可达。设一个4*6的格子图坐标如下：
 123456
 1######
 2######
 3######
 4######
 则(2,3)的格子与(1,3),(3,3),(2,2),(2,4)相邻。
 格子与格子之间存在特殊的墙，阻止两个相邻的格子的移动。若(2,3)存在一堵左侧的墙，则（2,3）将无法直接到达(2,2)，但(2,2)仍能到达(2,3)。
 现给出每个格子周围墙的情况，求从给定的点(S,T)出发，到达每一个格子最少经过多少个格子。

 输入
 第一行为一个正整数T(T＜=20)，表示测试数据的组数。
 对于每一组数据，第一行为n,m,S,T，(1＜=n＜=100, 1＜=m＜=100) (1＜=S＜=100) (1＜=T＜=100)。
 后面有n行，每行m个数字，第i行第j列的数字x表示格子(i,j)周围墙的情况。x的二进制表示中，从低位到高位数第1,2,3,4位分别表示该格子在上、下、左、右方向是否有墙。若有则该位为1，否则为0。
 输出
 对于每组数据，先输出一行"Case %:"，其中%代表第i组数据。每组数据输出n行，每行包含m个整数，第i行第j个整数代表从（S,T）出发到（i,j）的最小路程。若不能到达，该位置为-1。
 */
public class 格子距离 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for(int t = 0;t<T;t++) {
            String[] strings = in.nextLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);
            int[][] walls = new int[n][m];
            int S = Integer.parseInt(strings[2]);
            int D = Integer.parseInt(strings[3]);
            int[] start = new int[]{S-1, D-1};
            for(int i = 0;i<n;i++) {
                strings = in.nextLine().split(" ");
                int[] arr = new int[strings.length];
                for(int j = 0;j<strings.length ; j++) {
                    arr[j] = Integer.parseInt(strings[j]);
                }
                walls[i] = arr;
            }
            System.out.printf("Case %d:\n",t+1);
            solution(walls,start);
        }
    }

    private static void solution(int[][] walls, int[] start) {
        boolean[][] visited = new boolean[walls.length][walls[0].length];
        int[][] paths = new int[walls.length][walls[0].length];
        for(int i = 0; i<paths.length;i++) {
            for(int j=0;j<paths[0].length;j++) {
                paths[i][j] = -1;
            }
        }
        paths[start[0]][start[1]] = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int wall = walls[cur[0]][cur[1]];
            for(int i=0;i<=3;i++) {
                if ((wall & (1<<i)) == 0) {
                    int x = (cur[0] + dir[i][0]);
                    int y = (cur[1] + dir[i][1]);
                    if (x>=0 && x<walls.length && y>=0 &&y<walls[0].length&&!visited[x][y]) {
                        queue.add(new int[]{x, y});
                        paths[x][y] = paths[cur[0]][cur[1]]+1;
                        visited[x][y] = true;
                    }
                }
            }
        }

        for(int i = 0;i<paths.length;i++) {
            for(int j=0;j<paths[0].length;j++) {
                System.out.print(paths[i][j]+" ");
            }
            System.out.println();
        }
    }
}
