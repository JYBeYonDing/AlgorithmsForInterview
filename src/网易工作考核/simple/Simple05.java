package org.example.simple;

import java.util.Scanner;

/**
 * 检测回文字符串
 * 分数 30
 * 作者 
 * 单位 
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 1；否则，返回 0。
 *
 * 输入格式:
 * 一行包含一个字符串，长度大于0同时小于2000
 *
 * 输出格式:
 * 输入是一行，如果这个字符串是回文，返回 1，否则返回 0。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * A man, a plan, a canal: Panama
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * race a car
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Simple05 {

    public static void main(String[] args) {

        //read input
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        in.close();

        line = line.replaceAll("[^a-zA-Z0-9]","");
        line = line.toLowerCase();

        int s = 0, e = line.length() - 1;

        boolean eq = true;
        while(s < e) {
            if (line.charAt(s) != line.charAt(e)) {
                eq = false;
                break;
            }
            s++;
            e--;
        }

        System.out.println(eq ? 1 : 0);
    }
}
