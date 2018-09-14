package 校招2019.链家;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/3 19:55.
 *
 * 错误
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();
        int M = sc.nextInt();


        int[] counts = new int[4*Math.max(N, M)+1];
//        int[] counts = new int[];


        for (int i = 0; i <=N; i++) {
            counts[i] = N - i;
            if (2 * i > N) {
                counts[2 * i] = counts[i] + 1;
            }
        }



        if (M < N) {
            System.out.println(counts[M]);
        }



        int curMid = N + 1;
        int curMax = N * 2;

        while (curMid <= M) {
            for (int i = curMid; i <=curMax; i++) {
                if (counts[i] == 0) {
                    counts[i] = counts[i + 1] + 1;
                }
                counts[2 * i] = counts[i] + 1;
            }
            curMid = curMax + 1;
            curMax = curMax*2;

        }
        System.out.println(counts[M]);

    }



}