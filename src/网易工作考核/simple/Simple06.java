package org.example.simple;

import java.util.*;

/**
 * 同构字符串
 * 分数 30
 * 作者 
 * 单位 
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 输入格式:
 * 输入两个字符串s和t，且满足以下条件：
 *
 * 1 <= s.length <= 5 * 10^4
 *
 * t.length == s.length
 *
 * s 和 t 由任意有效的 ASCII 字符组成
 *
 * 输出格式:
 * 如果是同构字符串则返回1，否则返回 0
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * egg,add
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * foo,bar
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 0
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * paper,title
 * 输出样例3:
 * 在这里给出相应的输出。例如：
 *
 * 1
 */
public class Simple06 {

    public static void main(String[] args) {
        //read
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] words = line.split(",");

        Map<Character, Character> mapping = new HashMap<>();

        if(words[0].length() != words[1].length()) {
            System.out.println(0);
            return;
        }

        //检查 相同字符只能映射到同一个字符上
        for(int i = 0;i<words[0].length();i++) {
            if(!mapping.containsKey(words[0].charAt(i))) {
                mapping.put(words[0].charAt(i), words[1].charAt(i));
            } else {
                if(!mapping.get(words[0].charAt(i)).equals(words[1].charAt(i))) {
                    System.out.println(0);
                    return;
                }
            }
        }

        //检查 不同字符不能映射到同一个字符上
        Set<Character> distinct = new HashSet<>(mapping.values());
        if(distinct.size() != mapping.size()) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }
}
