package org.example.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 删除无效的括号
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 括号只考虑 "(" 和 ")" ，有效的括号是指一系列左括号 "(" 和 ")" 组成；但是如果有一些额外的括号，使得括号不能正确配对，就需要删除。
 *
 * 删除规则：从前往后，且尽可能少的删除多余括号。
 *
 * 输入格式:
 * 输入一个字符串，字符串的长度小于1000。字符串中只包含字母、 "(" 和 ")"
 *
 * 输出格式:
 * 输出处理后的字符串
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * a)())()
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * a()()
 */
public class Middle03 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        in.close();

        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();
        List<Character> result = new ArrayList<>();

        //所有是右括号入栈
        for(Character c : line1.toCharArray()) {
            if(')' == c) {
                rstack.push(c);
            }
        }

        for(int i = 0; i < line1.length(); i++) {
            char c = line1.charAt(i);
            //字母输出
            if(c != '(' && c != ')') {
                result.add(c);
                continue;
            }

            //左括号与右括号匹配,匹配到了就输出
            if(c == '(') {
                //没有匹配的括号
                if(rstack.isEmpty()) {
                    continue;
                } else {
                    lstack.push(c);
                    rstack.pop();
                    result.add(c);
                }
            }

            //右括号与左括号匹配,匹配到了就输出
            if(c == ')') {
                if(lstack.isEmpty()) {
                    continue;
                } else {
                    lstack.pop();
                    result.add(c);
                }
            }
        }

        //输出
        for(Character c : result) {
            System.out.print(c);
        }
        System.out.println();
    }
}
