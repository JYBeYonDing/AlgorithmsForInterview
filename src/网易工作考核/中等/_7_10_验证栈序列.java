package 网易工作考核.中等;

import java.util.Scanner;
import java.util.Stack;


/**
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 输入格式:
 * 第一行为输入序列，第二行为输出序列
 *
 * 输出格式:
 * true 或者 false
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 1,2,3,4,5
 * 4,5,3,2,1
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * true
 */
public class _7_10_验证栈序列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] pushs = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            pushs[i] = Integer.parseInt(split[i]);
        }
        split = in.next().split(",");
        int[] pops = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            pops[i] = Integer.parseInt(split[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushs.length; i++) {
            stack.push(pushs[i]);
            while (!stack.isEmpty() && stack.peek() == pops[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        System.out.println(stack.isEmpty());
    }
}
