package org.example.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 有效的括号
 * 分数 30
 * 作者 
 * 单位 
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
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * ()
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * ([{}])
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 1
 *
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * (]
 * 输出样例3:
 * 在这里给出相应的输出。例如：
 *
 * 0
 *
 * 输入样例4:
 * 在这里给出一组输入。例如：
 *
 * ([)]
 * 输出样例4:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Simple33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        in.close();

        Map<Character,Character> map = new HashMap<>(3);
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        int i = 0;
        char[] ops = op.toCharArray();
        while(i < ops.length) {
            if(map.containsKey(ops[i])) {
                stack.push(ops[i]);
                i++;
                continue;
            }

            if(stack.isEmpty() || map.get(stack.peek()) != ops[i]) {
                break;
            }

            stack.pop();
            i++;
        }

        //只判断栈为空无法覆盖 {{}}} 的场景
        System.out.println(!stack.isEmpty() || i < ops.length ? 0 : 1);
    }
}
