package 校招2019.华为;

import java.util.Scanner;

/**
 * Created by James on 2018/8/29 21:21.
 */
public class Main2_2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[][] a = new int[5][2];
            int[][] b = new int[5][2];
            for (int i = 0; i < 5 ; i++) {
                for (int j = 0; j <2 ; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 5 ; i++) {
                for (int j = 0; j <2 ; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            int[][] res = solve(a, b);
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j <2 ; j++) {
                    System.out.println(res[i][j]);
                }
            }
        }
        public static int[][] solve(int[][] a, int[][] b){
            int[][] res = new int[9][2];
            for (int i = 0; i < 9; i++) {
                for(int k = 0; k<=i&&k<5; k++) {
                    if(i-k<5) {
                        res[i][0] += a[i - k][0] * b[k][0] - a[i - k][1] * b[k][1];
                        res[i][1] += a[i - k][0] * b[k][1] + a[i - k][1] * b[k][0];
                    }
                }
            }
            return res;
        }


}
