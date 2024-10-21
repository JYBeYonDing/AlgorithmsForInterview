package org.example.simple;

import java.util.Scanner;

/**
 * 压缩字符串
 * 分数 30
 * 作者 
 * 单位 
 * 请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
 *
 *
 * 压缩规则：
 *
 * 1、字符串均为可见字符组成，仅压缩连续重复出现的单个字符；
 *
 * 2、若输入为空，则输出位空；
 *
 * 3、原字符串长度0<=length(s)<=10000
 *
 *
 * 输入格式:
 * 输入为长度[0,10000]的字符串，可能为空，字符均为可见字符
 *
 * 输出格式:
 * 输出为压缩后的字符串
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * abbccd
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * abcd
 */
public class Simple31 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        if("".equals(str)) {
            System.out.println("");
            return;
        }

        char[] chars = str.toCharArray();
        System.out.print(chars[0]);
        char pre = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == pre) {
                continue;
            }
            pre = chars[i];
            System.out.print(chars[i]);
        }
    }
}
