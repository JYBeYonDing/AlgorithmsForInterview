package 校招2019.招银信用卡;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/16 20:02.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();

        int[] turn = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};


        int res = 0;

        for (int i = 1; i <= N; i++) {

            int temp = i;

            int num = 0;
            int base = 1;
            boolean flag = true;
            while (temp != 0) {
                int b = temp % 10;
                temp = temp / 10;
                int turnB = turn[b];
                if (turnB == -1) {
                    flag = false;
                    break;
                } else {
                    num += base * turnB;
                    base *= 10;
                }

            }
            if (flag && num != i) {
                res++;
            }


        }

        System.out.println(res);
    }
}