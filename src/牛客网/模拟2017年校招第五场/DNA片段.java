package 牛客网.模拟2017年校招第五场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/17 17:26.
 * 牛牛从生物科研工作者那里获得一段字符串数据s,
 * 牛牛需要帮助科研工作者从中找出最长的DNA序列。
 * DNA序列指的是序列中只包括'A','T','C','G'。牛牛觉得这个问题太简单了,就把问题交给你来解决。
 例如: s = "ABCBOATER"中包含最长的DNA片段是"AT",所以最长的长度是2。
 输入描述:
 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括大写字母('A'~'Z')。

 输出描述:
 输出一个整数,表示最长的DNA片段

 输入例子1:
 ABCBOATER

 输出例子1:
 2
 */
public class DNA片段 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int max = 0;
        int count = 0;
        for(int i = 0;i<s.length() ; i++) {
            if (s.charAt(i) == 'A'||s.charAt(i)=='T'||s.charAt(i)=='C'||s.charAt(i)=='G') {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
