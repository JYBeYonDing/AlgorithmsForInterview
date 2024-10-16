package 网易工作考核.中等;

import java.util.Scanner;


/**
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c 成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * <p>
 * image.png
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * <p>
 * 1 <= b <= 10^9
 * <p>
 * 1 <= c <= 10^9
 * <p>
 * 输入格式:
 * 3个正整数a,b,c，以","分隔。
 * <p>
 * 输出格式:
 * 一个数字，字符串形式
 * <p>
 * 输入样例:
 * a,b,c分别为：
 * <p>
 * 1,2,3
 * 输出样例:
 * 最小翻转次数：
 * <p>
 * 0
 */
public class _7_2_或运算的最小翻转次数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bita = (a >> i) & 1;
            int bitb = (b >> i) & 1;
            int bitc = (c >> i) & 1;

            if (bitc == 0) {
                res += bita;
                res += bitb;
            }else{
                res += bita == 0 && bitb == 0 ? 1 : 0;
            }
        }
        System.out.println(res);

    }


}
