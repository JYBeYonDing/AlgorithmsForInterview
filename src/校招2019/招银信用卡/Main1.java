package 校招2019.招银信用卡;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/16 19:48.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" ");

        int[] g = new int[strs.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = Integer.parseInt(strs[i]);
        }

        strs = sc.nextLine().split(" ");
        int[] c = new int[strs.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(g);

        Arrays.sort(c);

        int gi=0;
        int ci = 0;

        int res = 0;
        while (ci < c.length && gi < g.length) {
            if (c[ci] >= g[gi]) {
                res++;
                ci++;
                gi++;
            } else {
                ci++;
            }
        }

        System.out.println(res);


    }
}