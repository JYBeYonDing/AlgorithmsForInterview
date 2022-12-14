package 剑指Offer;

import java.util.ArrayList;

/**
 * Created by 杨杰 on 2018/6/14 15:29.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2  3   4
 * 5 6  7   8
 * 9 10  11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return result;
        }
        int ax = 0;
        int ay = 0;
        int bx = matrix[0].length-1;
        int  by = matrix.length-1;
        while (ax <= bx && ay <= by) {
            printBound(matrix, ax++, ay++, bx--, by--, result);
        }
        return result;
    }

    private static void printBound(int[][] matrix, int ax, int ay, int bx, int by, ArrayList<Integer> result) {
        if (ay == by) {//单行
            for(int x=ax;x<=bx;x++) {
                result.add(matrix[ay][x]);
            }
        } else if (ax == bx) {//单列
            for (int y = ay; y <= by; y++) {
                result.add(matrix[y][ax]);
            }
        } else {// 多行多列
            for(int x=ax;x<=bx;x++) {
                result.add(matrix[ay][x]);
            }
            for (int y = ay+1; y <= by; y++) {
                result.add(matrix[y][bx]);
            }
            for(int x=bx-1;x>=ax;x--) {
                result.add(matrix[by][x]);
            }
            for (int y = by-1; y > ay; y--) {
                result.add(matrix[y][ax]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}};
        ArrayList<Integer> arrayList = printMatrix(matrix);
        for (int i : arrayList) {
            System.out.print(i+" ");
        }
    }
}
