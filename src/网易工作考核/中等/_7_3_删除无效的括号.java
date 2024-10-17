package 网易工作考核.中等;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 括号只考虑 "(" 和 ")" ，有效的括号是指一系列左括号 "(" 和 ")" 组成；但是如果有一些额外的括号，使得括号不能正确配对，就需要删除。
 * <p>
 * 删除规则：从前往后，且尽可能少的删除多余括号。
 * <p>
 * 输入格式:
 * 输入一个字符串，字符串的长度小于1000。字符串中只包含字母、 "(" 和 ")"
 * <p>
 * 输出格式:
 * 输出处理后的字符串
 * <p>
 * 输入样例:
 * 在这里给出一组输入。例如：
 * <p>
 * a)())()
 * 输出样例:
 * 在这里给出相应的输出。例如：
 * <p>
 * a()()
 */
public class _7_3_删除无效的括号 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removeList = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    removeList.add(i);
                    continue;
                } else {
                    stack.pop();
                    continue;
                }
            } else {
                stack.add(i);
            }
        }
        for (Integer i : stack) {
            removeList.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (removeList.contains(i)) {
                continue;
            } else {
                sb.append(charArray[i]);
            }
        }

        System.out.println(sb);
    }


}
