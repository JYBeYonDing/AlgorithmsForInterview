package org.example.middle;

import java.util.Scanner;

/**
 * 计算岛屿数量
 * 分数 30
 * 作者
 * 单位
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * 输入格式:
 * 表达二位数组的字符串，比如：[[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
 *
 * 输出格式:
 * 岛屿数量。例如：3。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * [[1,1,1,1,0];[1,1,0,1,0];[1,1,0,0,0];[0,0,0,0,0]]
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * [[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 3
 * 提示：
 * m == grid.length
 *
 * n == grid[i].length
 *
 * 1 <= m, n <= 300
 *
 * grid[i][j]  的值为'0'  或者'1'
 */
public class Middle14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        //[[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
        line = line.replaceAll("[\\[\\]]","");
        String[] arrs = line.split(";");
        int n = arrs.length;
        int[][] grid = null;
        int i = 0;
        for(String arr : arrs) {
            String[] nums = arr.split(",");
            int m = nums.length;
            int[] row = new int[m];
            if(grid == null) {
                grid = new int[n][m];
            }
            int j = 0;
            for(String num : nums) {
                row[j++] = Integer.parseInt(num);
            }
            grid[i++] = row;
        }

        int m = grid[0].length;
        int cnt = 0;
        i = 0;
        while(i < n) {
            int j = 0;
            while(j < m) {
                if(grid[i][j] == 0) {
                    j++;
                    continue;
                }
                cnt++;
                dfs(grid, i, j);
                j++;
            }
            i++;
        }
        System.out.println(cnt);

    }

    private static void dfs(int[][] grid, int i, int j) {
        if(grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        //上下左右
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            dfs(grid, i-1, j);
        }
        if(j-1 >=0 && grid[i][j-1] == 1){
            dfs(grid, i,j-1);
        }
        if(i + 1 < grid.length && grid[i+1][j] == 1) {
            dfs(grid,i+1,j);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == 1){
            dfs(grid, i,j+1);
        }
    }
}
