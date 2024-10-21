package org.example.middle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 或运算的最小翻转次数
 * 分数 30
 * 作者 
 * 单位 
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c 成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 *
 * image.png
 *
 * 提示：
 *
 * 1 <= a <= 10^9
 *
 * 1 <= b <= 10^9
 *
 * 1 <= c <= 10^9
 *
 * 输入格式:
 * 3个正整数a,b,c，以","分隔。
 *
 * 输出格式:
 * 一个数字，字符串形式
 *
 * 输入样例:
 * a,b,c分别为：
 *
 * 1,2,3
 * 输出样例:
 * 最小翻转次数：
 *
 * 0
 */
public class Middle02 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        in.close();

        String[] numsStr = line1.split(",");
        int[] arr = Arrays.stream(numsStr).mapToInt(Integer::valueOf).toArray();
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        int d = a | b;
        int e = d ^ c;

        System.out.println(Integer.bitCount(e) + Integer.bitCount(a&b&e));
    }
}
