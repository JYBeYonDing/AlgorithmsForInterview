package org.example.simple;

import java.util.Scanner;

/**
 * 最长回文子串
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个字符串s，找到s中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 输入格式:
 * 1<=s.length<=1000
 *
 * 输出格式:
 * s中最长的回文子串
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * zyrcbabd
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * bab
 */
public class Simple18 {

    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        in.close();

        int fl = -1;
        int fr = -1;
        int count = 0;

        for(int i = 0; i < line1.length(); i++){
            for(int j = line1.length() - 1;j >= i; j--) {
                if(line1.charAt(i) == line1.charAt(j)) {
                    int x = i;
                    int y = j;
                    do {
                        if(line1.charAt(x) != line1.charAt(y)) {
                            break;
                        }
                        x++;
                        y--;
                    } while (x < y);

                    if(x >= y) {
                        if(j - i + 1 > count){
                            fl = i;
                            fr = j;
                            count = j-i+1;
                        }
                    }
                }
            }
        }

        System.out.println(fl >= 0 ? line1.substring(fl, fr + 1) : "");
    }
}
