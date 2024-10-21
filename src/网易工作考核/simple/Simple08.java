package org.example.simple;

import java.util.Scanner;

/**
 * 最长的美好字符子串
 * 分数 30
 * 作者 
 * 单位 
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 */
public class Simple08 {

    public static void main(String[] args) {
        //read
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        //起点
        int k = -1;
        //长度
        int mx = 0;
        //枚举所有字串 o(n^2)
        for(int i = 0; i < str.length(); i++) {
            //存储小写位
            int lower = 0;
            //存储大写位
            int upper = 0;
            for(int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if(Character.isLowerCase(c)) {
                    lower |= 1 << (c - 'a');
                } else {
                    upper |= 1 << (c - 'A');
                }

                //每个字串都判断
                if(lower == upper && mx < j - i + 1) {
                    mx = j - i + 1;
                    k = i;
                }
            }
        }

        if(mx == -1) {
            System.out.println("");
            return;
        }

        System.out.println(str.substring(k, k + mx));
    }
}
