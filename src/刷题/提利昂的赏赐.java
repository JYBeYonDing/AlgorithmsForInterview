package 刷题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/7/6 16:55.
 * 提利昂收服山地部落之后决定犒赏士卒，本着陈力就列的原则，他决定给五种人以赏赐：
 1.作战能力＞80，并且至少有一项特殊能力的人，每人8000银鹿
 2.作战能力＞85，并且声望＞80的人，每人4000银鹿
 3.作战能力＞90，每人2000银鹿
 4.作战能力＞85的灼人部成员每人1000银鹿
 5.声望＞80的军官每人850银鹿。
 提利昂想要尽量多的犒赏部下，所以只要满足条件即可得到奖赏，
 即每人可以获得多项赏赐。请你帮他算算自己需要准备多少银鹿，
 并且他想要知道得到赏赐最多的人是谁，以及它得到的银鹿数量。
 */
public class 提利昂的赏赐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = Integer.parseInt(sc.nextLine());
        Solder maxSolder = null;
        int sum = 0;
        for (int n = 0; n < N; n++) {
            String[] strings = sc.nextLine().split(" ");
            String s = strings[0];
            int a = Integer.parseInt(strings[1]);
            int b = Integer.parseInt(strings[2]);
            char c = strings[3].charAt(0);
            char d = strings[4].charAt(0);
            int x = Integer.parseInt(strings[5]);
            Solder cur = new Solder(s, a, b, c, d, x);
            if (maxSolder == null || cur.sum > maxSolder.sum) {
                maxSolder = cur;
            }
            sum += cur.sum;
        }
        System.out.println(maxSolder.s);
        System.out.println(maxSolder.sum);
        System.out.println(sum);
    }
}
class Solder{
    String s;
    int a;
    int b;
    char c;
    char d;
    int x;
    int sum;
    public Solder(String s, int a, int b, char c, char d, int x) {
        this.s = s;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.x = x;
        sum = calcSum(a,b,c,d,x);
    }

    private int calcSum(int a, int b, char c, char d, int x) {
        int sum = 0;
        if (a > 80 && x >= 1) {
            sum += 8000;
        }
        if (a > 85 && b > 80) {
            sum += 4000;
        }
        if (a > 90) {
            sum += 2000;
        }
        if (a > 85 && d == 'Y') {
            sum += 1000;
        }
        if (b > 80 && c == 'Y') {
            sum += 850;
        }
        return sum;
    }

}