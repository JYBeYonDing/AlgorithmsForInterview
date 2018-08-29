package 校招2019.华为;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/29 19:35.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int k = sc.nextInt();
        int M = 0;
        int N = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            res.add(solution(M, N));
        }

        for (int r : res) {
            System.out.println(r);
        }
    }

    private static int solution(int m, int n) {
        if (n == 1 || n == 2 || n == 3) {
            return (n + 1) * m;
        }
        int res = 5;
        int pre = 4;
        int prepre = 3;
        int preprepre = 2;
        int tmp1 = 0;
        int tmp2 = 0;
        int tmp3 = 0;
        for (int i = 5; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            tmp3 = prepre;
            res = res + preprepre;
            pre = tmp1;
            prepre = tmp2;
            preprepre = tmp3;
        }
        return res * m;
    }
}