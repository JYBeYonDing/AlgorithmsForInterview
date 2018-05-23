package 牛客网.网易2018校园招聘;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/18 22:25.
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。

 输入描述:
 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')


 输出描述:
 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。

 如样例所示: s = "aaabbaaac"
 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25

 输入例子1:
 aaabbaaac

 输出例子1:
 2.25
 */
public class 字符串碎片 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.printf("%.2f",solution(s));
    }

    private static double solution(String s) {
        int count = 1;
        int sum = 0;
        int num = 0;
        char pre = s.charAt(0);
        for(int i = 1 ;i< s.length() ;i++) {
            if (s.charAt(i) == pre) {
                count++;
            } else {
                sum += count;
                count = 1;
                num++;
                pre = s.charAt(i);
            }
        }

        sum += count;
        num++;
        return sum / (double) num;

    }
}
