package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 10:12.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int M = sc.nextInt();

        int[][] m = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println(count(m,M));

    }

    private static int count(int[][] m, int M) {
        if (m[0] == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, M);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int M) {
        if (i < 0 || i >= M || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, M);
        infect(m, i - 1, j, M);
        infect(m, i, j + 1, M);
        infect(m, i, j - 1, M);
    }
}