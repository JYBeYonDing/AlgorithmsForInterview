package 网易工作考核;

import java.util.Scanner;

public class _7_9最小硬币个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            Long stdin = in.nextLong();
            if (stdin <= 0 || stdin > 2147483647) {
                System.out.println("-1");
            } else {
                System.out.println(stdin / 5 + stdin % 5 / 2 + stdin % 5 % 2);
            }
        }
    }
}
