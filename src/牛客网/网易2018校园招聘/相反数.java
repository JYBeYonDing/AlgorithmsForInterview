package 牛客网.网易2018校园招聘;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/18 22:15.
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,
 * 然后再加上原先的数得到"相反数"。
 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,
 * 之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
 * 输入描述:
 * 输入包括一个整数n,(1 ≤ n ≤ 10^5)
 * <p>
 * 输出描述:
 * 输出一个整数,表示n的相反数
 * <p>
 * 输入例子1:
 * 1325
 * <p>
 * 输出例子1:
 * 6556
 */
public class 相反数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        char[] ns = (n + "").toCharArray();
        reverse(ns);
        int re = Integer.parseInt(new String(ns));
        return n + re;
    }

    private static void reverse(char[] ns) {
        int l = 0;
        int r = ns.length - 1;
        while (l < r) {
            char temp = ns[l];
            ns[l] = ns[r];
            ns[r] = temp;
            l++;
            r--;
        }
//        System.out.println(Integer.parseInt(new String(ns)));
    }
}
