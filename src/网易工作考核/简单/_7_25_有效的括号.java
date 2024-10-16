package 网易工作考核.简单;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须在之后有相同类型的右括号配对，配对仅能一次
 *
 * 所有类型的括号必须以正确的顺序配对，先有左括号，再有右括号
 *
 * 括号要按顺序配对，不能出现不同类型的括号相互交叠
 *
 * 提示：
 *
 * 1 <= s.length <= 10^4
 *
 * s 仅由括号 '()[]{}' 组成
 *
 * 运行有时间和内存限制
 *
 * 输入格式:
 * 多个括号组成的字符串
 *
 * 输出格式:
 * 0 or 1
 */
public class _7_25_有效的括号 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int res = 1;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else{
                if (stack.isEmpty()) {
                    res = 0;
                    break;
                }
                Character pop = stack.pop();
                if (c == ')') {
                    if (pop != '(') {
                        res = 0;
                        break;
                    }
                } else if (c == ']') {
                    if (pop != '[') {
                        res = 0;
                        break;
                    }
                } else if (c == '}') {
                    if (pop != '{') {
                        res = 0;
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            res = 0;
        }

        System.out.println(res);
    }


}
