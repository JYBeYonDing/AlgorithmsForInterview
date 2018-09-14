package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 11:04.
 */
public class Main555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();

        int M = sc.nextInt();


        int[][] like = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            like[x][y] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i!=j && like[i][j] == 1) {
                    // 如果i关注了j
                    for (int k = 1; k <= N; k++) {
                        if (k != i && like[j][k] == 1) {
                            like[i][k] = 1;

                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= N; j++) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (like[i][j] == 1) {
                    sum++;
                }
            }
            if (sum == N-1) {
                res++;
            }

        }

        System.out.println(res);

    }

}