package 校招2019.网易校招;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/8 16:03.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int t = sc.nextInt();

        int[][] res = new int[t][2];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            res[i][1] = Math.min(k - 1>0?k-1:0, n - k);

        }


        for (int i = 0; i < t; i++) {
            System.out.println(0 + " " + res[i][1]);
        }
    }
}