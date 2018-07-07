package 刷题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int q = scanner.nextInt();
            int c = 0;
            while (c++ < q) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int[] ss = new int[a];
                Set<Integer> es = new HashSet<>(b);
                int[][] routes = new int[n][n];
                for (int i = 0; i < a; i++) {
                    ss[i] = scanner.nextInt()-1;
                }
                for (int i = 0; i < b; i++) {
                    es.add(scanner.nextInt()-1);
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        routes[i][j] = Integer.MAX_VALUE;
                    }
                }
                for (int i = 0; i < m; i++) {
                    int j = scanner.nextInt()-1;
                    int k = scanner.nextInt()-1;
                    routes[j][k] = scanner.nextInt();
                    routes[k][j] = routes[j][k];
                }
                boolean[] visited = new boolean[n];
                for (int i = 1; i < a; i++) {
                    routes[ss[0]][ss[i]] = 0;
                    routes[ss[i]][ss[0]] = 0;
                }
                visited[ss[0]] = true;
                boolean flag = true;
                while (true) {
                    int min = ss[0];
                    for (int i = 0; i < n; i++) {
                        if (!visited[i] && routes[ss[0]][min] > routes[ss[0]][i]) {
                            min = i;
                        }
                    }
                    if (min == ss[0]) {
                        break;
                    }
                    visited[min] = true;
                    if (es.contains(min)) {
                        flag = false;
                        System.out.println("Case #" + c + ": " + routes[ss[0]][min]);
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        if (!visited[i] && routes[min][i] < Integer.MAX_VALUE && routes[ss[0]][min] + routes[min][i] < routes[ss[0]][i]) {
                            routes[ss[0]][i] = routes[ss[0]][min] + routes[min][i];
                        }
                    }
                }
                if (flag)
                    System.out.println("Case #" + c + ": No answer");
            }
        }
    }
}