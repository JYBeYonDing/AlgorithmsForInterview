package 校招2019.京东;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by James on 2018/9/9 20:09.
 */
public class Main2222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

        int[][] goods = new int[n][3];

        for (int i = 0; i < n; i++) {
            goods[i][0] = sc.nextInt();
            goods[i][1] = sc.nextInt();
            goods[i][2] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (goods[j][0] > goods[i][0] && goods[j][1] > goods[i][1] && goods[j][2] > goods[i][2]) {
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }


}