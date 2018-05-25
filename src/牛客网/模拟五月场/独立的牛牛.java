package 牛客网.模拟五月场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/23 19:30.
 * 小牛牛为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 一个人生活增加了许多花费: 牛牛每天必须吃一个水果并且需要每天支付x元的房屋租金。
 当前牛牛手中已经有f个水果和d元钱,牛牛也能去商店购买一些水果,商店每个水果售卖p元。
 牛牛为了表现他独立生活的能力,希望能独立生活的时间越长越好,牛牛希望你来帮他计算一下他最多能独立生活多少天。
 输入描述:
 输入包括一行,四个整数x, f, d, p(1 <= x,f,d,p <= 2 * 10^9),以空格分割
 输出描述:
 输出一个整数, 表示牛牛最多能独立生活多少天。
 示例1
 输入
 3 5 100 10
 输出
 11
 */
public class 独立的牛牛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();//每天房子租金
        int f = sc.nextInt();//已经有f个水果
        int d = sc.nextInt();//已经有d元
        int p = sc.nextInt();//每个水果售价
        System.out.println(solution(x,f,d,p));
        System.out.println(solutionNiuKe(x,f,d,p));
    }

    /**
     * 牛客网参考答案
     * 首先计算能保证的房屋能租多少天,如果有剩余再考虑购买水果。
     */
    private static int solutionNiuKe(int x, int f, int d, int p) {
        int tmp1 = d / x;
        if (tmp1 <= f) {
            return tmp1;
        }
        d -= f * x;
        return f + d / (x + p);
    }

    private static int solution(int x, int f, int d, int p) {
        int a = d/x;//水果充足
//        long b = (p*f+d)/(p+x);
        int b = (d-f*x)/(p+x)+f;
        return Math.min(a, b);
    }
}
