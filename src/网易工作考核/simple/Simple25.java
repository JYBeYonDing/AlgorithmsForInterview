package org.example.simple;

import java.util.Scanner;
import java.util.Stack;

/**
 * 魔法师的秘密
 * 分数 30
 * 作者 
 * 单位 
 * 霍霍霍霍魔法学院里面来了一位超级魔法师哈里·特波，他法力高强，但却爱搞恶作剧。这不，他一来就给学院里的基础咒语书施放“特波消失术”的魔法，搞得书上的咒语都变了样，大家学的咒语都失灵了。幸好特波有说梦话的坏习惯，你在无意中听到了原来所谓的“特波消失术”是将咒语中连续3个相同的符号合并为1个，并跟上一个特波的图腾“~”，如“abac~”的原咒语是“abaccc”，“c~~”的原咒语为“ccccc”。
 *
 * 原字符串由小写字母组成，长度为[3,10000], 输入必包含图腾字符“~”
 *
 * 输入格式:
 * 字符串由小写字母组成，长度为[3,10000], 输入必包含图腾字符“~”
 *
 * 输出格式:
 * 还原后的字符串，长度为[3,10000]
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * abac~
 * ab~c~~
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * abaccc
 * abbbccccc
 */
public class Simple25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();

        in.close();

        //注意，实际上只有一行输入
        System.out.println(recover(s1));
    }

    private static String recover(String str) {
        Stack<Character> stack = new Stack<>();
        char[] cs = str.toCharArray();
        for(char c : cs) {
            if(c != '~') {
                stack.push(c);
            } else {
                char pre = stack.pop();
                stack.push(pre);
                stack.push(pre);
                stack.push(pre);
            }
        }

        int i = stack.size() - 1;
        char[] res = new char[stack.size()];
        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return new String(res);
    }
}
