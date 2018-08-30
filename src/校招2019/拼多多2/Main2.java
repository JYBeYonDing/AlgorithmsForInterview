package 校招2019.拼多多2;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/30 19:40.
 *
 * 3 4
 * .oxo
 * o..o
 * .xox
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        String[] strs = sc.nextLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);

        char[][] table = new char[N][M];
        String str;
        for (int i = 0; i < N; i++) {
            str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = str.charAt(j);
            }
        }


        solution(table, N, M);

        for (int i = 0; i < N; i++) {
            System.out.println(new String(table[i]));
        }
    }

    private static void solution(char[][] table, int n, int m) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 'o') {
                    move(table, i, j, n, m);
                }
            }
        }
    }

    private static void move(char[][] table, int x, int y, int n, int m) {
        for (int i = x + 1; i <= n; i++) {
            if (i == n) {
                table[x][y] = '.';
                return;
            } else {
                if (table[i][y] == 'o'||table[i][y]=='x') {
                    table[i - 1][y] = 'o';
                    return;
                }
                if (table[i][y] == '.') {
                    table[x][y] = '.';
                }
            }
        }
    }
}