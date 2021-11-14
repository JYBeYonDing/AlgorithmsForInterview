package 校招2019.小米;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/27 15:16.
 */
public class Main2 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();
        int M = sc.nextInt();



        int sum = 0;
        for (int i = 1; i <= N; i++) {





        }
    }


    private static void solution(int index, int N, int sum, int M) {
        if (index == N) {
            if (sum == M) {
                res++;
            }
        }

        sum = sum + index;
        solution(index + 1, N, sum, M);

        sum = sum - index - index;
        solution(index+1,N,sum,M);

        sum = sum - (index - 1) + (index - 1) * 10 + index;
        solution(index+1,N,sum,M);
    }
}