package 校招2019.链家;

import java.util.Scanner;

/**
 * Created by James on 2018/9/3 21:28.
 */
public class Main22 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(solve(N, M));
    }

    public static int solve(int N, int M) {
        int res = 0;
        if (N >= M) {
            return N - M;
        } else {
            while (M != N) {
                if (M % 2 == 0 && M > N) {
                    res++;
                    M = M / 2;
                } else {
                    if (N >= M) {
                        res = res + (N - M);
                        break;
                    }
                    M = (M + 1) / 2;
                    res = res + 2;
                }

            }
            return res;
        }
    }

}
