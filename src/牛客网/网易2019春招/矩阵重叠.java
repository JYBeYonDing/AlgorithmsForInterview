package 牛客网.网易2019春招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/25 15:16.
 * <p>
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * <p>
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 * <p>
 * 输入例子1:
2
0 90
0 90
100 200
100 200
 * <p>
 * 输出例子1:
 * 2
 */
public class 矩阵重叠 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        int[] x = new int[2 * n];
        int[] y = new int[2 * n];
        for (int i = 0; i < n; i++) {
            x1[i] = scanner.nextInt();
            x[i] = x1[i];
        }
        for (int i = 0; i < n; i++) {
            y1[i] = scanner.nextInt();
            y[i] = y1[i];
        }
        for (int i = 0; i < n; i++) {
            x2[i] = scanner.nextInt();
            x[i + n] = x2[i];
        }
        for (int i = 0; i < n; i++) {
            y2[i] = scanner.nextInt();
            y[i + n] = y2[i];
        }
        System.out.println(solution(x,y,x1, y1, x2, y2));
    }

    /**
     * 暴力求解复杂度比较大
     * 扫描每一个顶点在矩阵中出现的次数
     */
    private static int solution(int[] x, int[] y, int[] x1, int[] y1, int[] x2, int[] y2) {
        int max =0;
        for (int xi : x) {
            for (int yi : y) {
                int sum = 0;
                for(int k=0;k<x1.length;k++) {
                    if (xi >= x1[k] && xi < x2[k] && yi >= y1[k] && yi < y2[k]) {
                        sum++;
                    }
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    
}
