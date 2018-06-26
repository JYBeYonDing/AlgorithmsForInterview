package Java面试慕课课程.BuautifulNumbers;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/26 9:11.
 */
public class BeautifulNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println(solution(sc.nextInt()));
        }
    }

    private static int solution(int n) {
        for(int radix = 2; radix<n;radix++) {
            int num = n;
            while (true) {
                if (num % radix != 1) {
                    break;
                }
                num = num / radix;
                if (num == 0) {
                    return radix;
                }
            }
        }
        throw new IllegalStateException("Should not reach here.");
    }
}
