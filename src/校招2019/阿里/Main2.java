package 校招2019.阿里;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by James on 2018/9/7 19:58.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        String[] strs = sc.nextLine().split(",");
        int x = Integer.parseInt(strs[0]);
        int y = Integer.parseInt(strs[1]);

        int[] p = {x, y};

        strs = sc.nextLine().split(",");

        int numOfPoints = strs.length / 2;
        int[][] polygon = new int[numOfPoints][2];

        for (int i = 0; i < numOfPoints; i++) {
            polygon[i][0] = Integer.parseInt(strs[i * 2]);
            polygon[i][1] = Integer.parseInt(strs[i * 2 + 1]);
        }


        int dis = (int) pointToPolygonDist(p, polygon);
        if (dis >= 0) {
            System.out.println("yes,0");
        } else {
            System.out.println("no," + -dis);
        }

    }


    private static double pointToPolygonDist(int[] p, int[][] polygon) {
        int count = 0;
        double minDist = Integer.MAX_VALUE;
        for (int k = 0; k < polygon.length - 1; k++) {

            int[] a = polygon[k];
            int[] b = polygon[k + 1];
            if ((a[1] > p[1] != b[1] > p[1]) && (p[0] < (b[0] - a[0]) * (p[1] - a[1]) / (b[1] - a[1]) + a[0])) count++;
            minDist = Math.min(minDist, pointToSegmentDist(p, a, b));

        }
        if (count % 2 == 0) minDist = -minDist;
        return minDist;
    }


    private static double pointToSegmentDist(int[] p, int[] a, int[] b) {
        int[] AB = {b[0] - a[0], b[1] - a[1]};
        int[] AP = {p[0] - a[0], p[1] - a[1]};
        int AB_AP = AB[0] * AP[0] + AB[1] * AP[1];
        int distAB2 = AB[0] * AB[0] + AB[1] * AB[1];
        double[] D = {a[0], a[1]};
        if (distAB2 != 0) {
            double t = AB_AP / (double)distAB2;
            if (t > 1) {
                D = new double[]{b[0], b[1]};
            } else if (t > 0) {
                D = new double[]{a[0] + AB[0] * t, a[1] + AB[1] * t};
            } else {
                D = new double[]{a[0], a[1]};
            }
        }
        double[] AD = {p[0] - D[0], p[1] - D[1]};
        return Math.sqrt(AD[0] * AD[0] + AD[1] * AD[1]);
    }
}
