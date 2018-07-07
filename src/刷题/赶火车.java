package 刷题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 杨杰 on 2018/7/6 17:16.
 */
public class 赶火车 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] strings = scanner.nextLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);
            int a = Integer.parseInt(strings[2]);
            int b = Integer.parseInt(strings[3]);
            strings = scanner.nextLine().split(" ");
            Set<Integer> A = new HashSet<>();
            for (String string : strings) {
                A.add(Integer.parseInt(string) - 1);
            }

            strings = scanner.nextLine().split(" ");
            Set<Integer> B = new HashSet<>();
            for (String string : strings) {
                B.add(Integer.parseInt(string) - 1);
            }

            int[][] paths = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    paths[i][j] = INF;
                    if (i == j) {
                        paths[i][j] = 0;
                    }
                }
            }
            for (int mi = 0; mi < m; mi++) {
                strings = scanner.nextLine().split(" ");
                int u = Integer.parseInt(strings[0]) - 1;
                int v = Integer.parseInt(strings[1]) - 1;
                int w = Integer.parseInt(strings[2]);
                paths[u][v] = w;
                paths[v][u] = w;
            }

            int minPathLen = findMinPathLen(paths, A, B);
            if (minPathLen == INF) {
                System.out.printf("Case #%d: No answer\n", t + 1);
            } else {
                System.out.printf("Case #%d: %d\n", t + 1, minPathLen);
            }

        }

    }

    private static int findMinPathLen(int[][] paths, Set<Integer> A, Set<Integer> B) {
        int n = paths.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = (paths[i][k] == INF || paths[k][j] == INF) ? INF : paths[i][k] + paths[k][j];
                    if (paths[i][j] > temp) {
                        paths[i][j] = temp;
                        paths[j][i] = temp;
                    }
                }
            }
        }
        int min = INF;
        for (int a : A) {
            for (int b : B) {
                if (paths[a][b] < min) {
                    min = paths[a][b];
                }
            }

        }
        return min;
    }
}
