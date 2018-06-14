package 牛客网.模拟六月场;

import java.util.Scanner;

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
 */
public class 牛牛游玩记 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] map = new char[n][n];
        String str = null;
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
        solution(map);
    }

    private static void solution(char[][] map) {
        int exitX = 0;
        int exitY = 0;

        for(int i=0;i<map.length;i++) {
            for(int j = 0; j<map[0].length;j++) {
                if (map[i][j] == '*') {
                    exitX=i;
                    exitY = j;
                }
            }
        }

        findPath(map, exitX, exitY);
    }

    private static void findPath(char[][] map, int exitX, int exitY) {

    }

    private static void findPathRec(char[][] map, int x, int y,int step) {
        if (map[x][y] == '@') {

        }
    }
}
