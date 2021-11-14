package 校招2019.Keep;

import java.util.Arrays;
import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int d = sc.nextInt();
        if (s > 9 * d) {
            System.out.println(-1);
            return;
        }
        int res = 0;
        int base = 1;
        s = s - 1;
        int tempD = d-1;
        while (s >= 9) {
            res += base * 9;
            base *= 10;
            s -= 9;
            tempD--;
        }
        res += base * s;
        if (tempD == 0) {
            System.out.println(base+res);
            return;
        }
        base *= 10;
        tempD--;
        while (tempD > 0) {
            base *= 10;
            tempD--;
        }
        System.out.println(base + res);
    }

}
