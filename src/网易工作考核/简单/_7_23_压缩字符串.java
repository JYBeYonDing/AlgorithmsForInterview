package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
 * <p>
 * <p>
 * 压缩规则：
 * <p>
 * 1、字符串均为可见字符组成，仅压缩连续重复出现的单个字符；
 * <p>
 * 2、若输入为空，则输出位空；
 * <p>
 * 3、原字符串长度0<=length(s)<=10000
 * <p>
 * 输入格式:
 * 输入为长度[0,10000]的字符串，可能为空，字符均为可见字符
 * <p>
 * 输出格式:
 * 输出为压缩后的字符串
 */
public class _7_23_压缩字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i==0 || sb.charAt(sb.length() - 1) != charArray[i]) {
                sb.append(charArray[i]);
            }
        }

        System.out.println(sb);
    }


}
