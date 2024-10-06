package 网易工作考核.简单;

import java.util.Scanner;

public class _7_6_数字拆分求和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        boolean res = false;
        for (int x = 1; x <= k / 2; x++) {
            int sum = 0;
            String str = "";
            int num = x;
            int dif = 1;
            while (sum < k) {
                sum += num;
                if (sum == k) {
                    str += num;
                    if (res) {
                        System.out.println();
                    }
                    System.out.print(str);
                    res = true;
                    continue;
                }
                str += num + ",";
                num = num + dif;
                dif += 1;
            }
        }
        if (!res) {
            System.out.print("");
        }
    }
}
