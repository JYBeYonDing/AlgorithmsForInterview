package org.example.hard;

import java.util.Scanner;

/**
 * 计算岛屿最大面积
分数 60
作者 
单位 
给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

示例 1：

输入：grid = [

[1, 1, 0, 0, 0];

 [1, 1, 0, 0, 0];

[0, 0, 1, 0, 0];

 [0, 0, 0, 1, 1]] 

输出：4

示例 2：

输入：grid = [[0,0,0,0,0,0,0,0]]

输出：0

输入格式:
参考下方输入样例，字符串表示的二维数组。例如：[[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]

输出格式:
数字。例如：4


输入样例:
在这里给出一组输入。例如：

[[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
输出样例:
在这里给出相应的输出。例如：

4
 */
public class Hard06 {

    //dfs
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String m = in.nextLine();
        in.close();

        m = m.substring(1, m.length() - 1);
        String[] lines = m.split(";");
        byte[][] matrix = null;
        for (int i = 0; i < lines.length; i++) {
            String lines2 = lines[i];
            lines2 = lines2.substring(1,lines2.length() - 1);
            String[] l = lines2.split(",");

            if (matrix == null) {
                matrix = new byte[lines2.length()][l.length];
            }

            for (int j = 0; j < l.length; j++) {
                matrix[i][j] = Byte.valueOf(l[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    int s = 1 + island(matrix, i, j);
                    max = Math.max(max, s);
                }
            }
        }

        System.out.println(max);
    }

    private static int island(byte[][] m, int i, int j) {
        int s = 0;

        // 上
        if (i - 1 >= 0 && m[i - 1][j] == 1) {
            s += 1;
            m[i - 1][j] = 0;
            s += island(m, i - 1, j);
        }

        // 下
        if (i + 1 < m.length && m[i + 1][j] == 1) {
            s += 1;
            m[i + 1][j] = 0;
            s += island(m, i + 1, j);
        }

        // 左
        if (j - 1 >= 0 && m[i][j - 1] == 1) {
            s += 1;
            m[i][j - 1] = 0;
            s += island(m, i, j - 1);
        }

        // 右
        if (j + 1 < m[i].length && m[i][j + 1] == 1) {
            s += 1;
            m[i][j + 1] = 0;
            s += island(m, i, j + 1);
        }

        return s;
    }
}
