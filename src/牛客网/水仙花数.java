package 牛客网;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/11 17:42.
 */
public class 水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String[] strings = sc.nextLine().split(" ");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);
            solution(start, end);
        }
    }

    private static void solution(int start, int end) {
        boolean hasNo = true;
        for(int i=start;i<=end;i++) {
            if (isShu(i)) {
                if (hasNo) {
                    hasNo = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print(i);
            }
        }
        if (hasNo) {
            System.out.println("no");
        } else {
            System.out.println();
        }
    }

    private static boolean isShu(int i) {
        int temp = i;
        int z = i % 10;
        i = i / 10;
        int y = i % 10;
        i = i / 10;
        int x = i;
        if (temp == x * x * x + y * y * y + z * z * z) {
            return true;
        } else {
            return false;
        }
    }
}
