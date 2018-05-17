package 牛客网.模拟2017年校招第五场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/17 17:32.
 *
 * 用了KMP的next数组，没有仔细思考！！！
 *
 * 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。
 * 例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 * 牛牛现在给你一个只包含小写字母的偶串s,
 * 你可以从字符串s的末尾删除1和或者多个字符,
 * 保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。

 输入描述:
 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成

 输出描述:
 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解

 输入例子1:
 abaababaab

 输出例子1:
 6
 */
public class 偶串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        s = s.substring(0, s.length() - 1);
        if (allSame(s)) {
            return s.length() / 2 * 2;
        } else {
            int[] next = getNextArray(s.toCharArray());
            for(int i = next.length-1; i>=0 ; i--) {
                if (i == next[i] * 2) {
                    return i;
                }
            }
            return 0;
        }

    }

    private static boolean allSame(String s) {
        for (int i = 1 ; i<s.length() ; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;// 当前位置
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {// 如果不相等，且cn>0，则往前跳
                cn = next[cn];// cn往前跳，跳到cn位置处前缀的下一个字符
            } else {// cn已经跳到0位置
                next[pos++] = 0;
            }
        }
        return next;
    }
}
