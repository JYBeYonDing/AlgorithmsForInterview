package 牛客网.网易2017实习生;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/10 17:41.
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 * 输入描述:
 * 每个测试输入包含1个测试用例
 * 每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。
 * <p>
 * <p>
 * 输出描述:
 * 输出编码后的字符串
 * <p>
 * 输入例子1:
 * AAAABCCDAA
 * <p>
 * 输出例子1:
 * 4A1B2C1D2A
 */
public class 字符串编码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solotion(s));
    }

    private static String solotion(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char temp = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == temp) {
                count++;
            } else {
                sb.append(count);
                sb.append(temp);
                temp = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(temp);
        return sb.toString();
    }
}
