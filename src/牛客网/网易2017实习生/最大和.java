package 牛客网.网易2017实习生;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/10 17:53.
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
 输入描述:
 每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
 3 <= N <= 100
 1 <= D <= N
 接下来有N行，每行N个数字d:
 0 <= d <= 100


 输出描述:
 输出一个整数，表示找到的和的最大值

 输入例子1:
 4 2
 87 98 79 61
 10 27 95 70
 20 64 73 29
 71 65 15 0

 输出例子1:
 193
 */
public class 最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[][] matrix = new int[N][N];
        for(int i = 0 ; i< N ; i++) {
            for(int j = 0 ; j<N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(matrix, D));
    }

    private static int solution(int[][] matrix, int d) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                max = Math.max(max, sum(matrix, i, j, d));
            }
        }
        return max;
    }

    private static int sum(int[][] matrix, int i, int j, int d) {
        int max = Integer.MIN_VALUE;
        int ru = 0;
        if (i + 1 >= d && matrix.length - j >= d) {
            for(int n = 0 ;n<d ;n++) {
                ru += matrix[i - n][j + n];
            }
        }
        max = Math.max(max, ru);
        int rd = 0;
        if (matrix.length - i >= d && matrix.length - j >= d) {
            for(int n = 0 ;n<d ;n++) {
                rd += matrix[i + n][j + n];
            }
        }
        max = Math.max(max, rd);
        int r = 0;
        if ( matrix.length - j >= d) {
            for(int n = 0 ;n<d ;n++) {
                r += matrix[i][j + n];
            }
        }
        max = Math.max(max, r);
        int down = 0;
        if ( matrix.length - i >= d) {
            for(int n = 0 ;n<d ;n++) {
                down += matrix[i+n][j];
            }
        }
        max = Math.max(max, down);
        return max;
    }
}
