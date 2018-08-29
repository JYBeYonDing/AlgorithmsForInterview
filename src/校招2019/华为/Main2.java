package 校招2019.华为;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/29 19:59.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int[][] ab = new int[4][5];



        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                ab[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < 5; j++) {
            for (int i = 2; i < 4; i++) {
                ab[i][j] = sc.nextInt();
            }
        }


        int[] resR = new int[9];
        int[] resI = new int[9];

        solution(ab, resR, resI);

        for (int i = 0; i < resI.length; i++) {
            System.out.println(resR[i]);
            System.out.println(resI[i]);

        }
    }

    private static void solution(int[][] ab, int[] resR, int[] resI) {
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k <= i; k++) {
                if (k <= 4 && (i - k) <= 4) { //防止越界
                    resR[i] += ab[0][k] * ab[2][i - k] - ab[1][k] * ab[3][i - k];
                    resI[i] += ab[0][k] * ab[3][i - k] + ab[1][k] * ab[2][i - k];
                }

            }

        }

    }
}