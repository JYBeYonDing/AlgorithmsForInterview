package org.example.simple;

import java.util.Scanner;

/**
 * 大山的数目
 * 分数 30
 * 作者 
 * 单位 
 * Drizzle 前往山地统计大山的数目，现在收到这片区域的地图，地图中用0（平地）和1（山峰）绘制而成，请你帮忙计算其中的大山数目。
 *
 * 山总是被平地四面包围着，每一座山只能在水平或垂直方向上连接相邻的山峰而形成。一座山峰四面被平地包围，这个山峰也算一个大山。
 *
 * 另外，你可以假设地图的四面都被平地包围着。
 *
 * 输入格式:
 * 第一行输入M,N分别表示地图的行列，接下来M行每行输入N个数字表示地图。
 *
 *
 * 范围:
 *
 * 对于 5% 的数据：M，N ≤ 10
 * 对于 100% 的数据：M，N ≤ 2000
 *
 * 输出格式:
 * 输出一个整数表示大山的数目。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 4 5
 * 1 1 0 0 0
 * 1 1 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3
 */
public class Simple03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m,n;
        m = in.nextInt();
        n = in.nextInt();

        int[][] arr  = new int[m][n];

        for(int i = 0;i<m;i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();

        int c = 0;

        for(int i = 0;i<m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    c++;
                    dfs(arr, i, j);
                }
            }
        }

        System.out.println(c);
    }

    private static void dfs(int[][] arr, int i, int j) {
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length) {
            return;
        }
        if(arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 0;

        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
    }}
