package org.example.middle;

import java.util.Scanner;
import java.util.Stack;

/**
 * 验证栈序列
 * 分数 30
 * 作者
 * 单位
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
 * 解释1:
 * 我们可以按以下顺序执行：
 *
 * push(1), push(2), push(3), push(4), pop() -> 4,
 *
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 1,2,3,4,5
 * 4,3,5,1,2
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * false
 * 解释2:
 * 1 不能在 2 之前弹出。
 *
 *
 *
 * 提示:
 * 1 <= pushed.length <= 1000
 *
 * 0 <= pushed[i] <= 1000
 *
 * pushed 的所有元素 互不相同
 *
 * popped.length == pushed.length
 *
 * popped 是 pushed 的一个排列
 *
 * 返回的字符串需要是小写的！
 */
public class Middle11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();

        String[] nums1 = num1.split(",");
        String[] nums2 = num2.split(",");

        Stack<String> psh = new Stack<>();
        // 先压入第一个元素
        psh.push(nums1[0]);
        // 两个指针，分别指向两个数组, 第一个元素已经压入栈中
        int idx1 = 1;
        int idx2 = 0;
        while(idx1 < nums1.length && idx2 < nums2.length) {
            // 如果栈不为空，且栈顶元素等于popped的元素，则弹出栈顶元素
            if(!psh.isEmpty () && nums2[idx2].equals(psh.peek())) {
                psh.pop();
                idx2++;
            } else {
                // 否则，继续压栈
                psh.push(nums1[idx1]);
                idx1++;
            }
        }
        // 如果popped的元素已经全部弹出，但是栈不为空，则继续弹出栈顶元素
        while(idx2 < nums2.length && !psh.isEmpty() && nums2[idx2].equals(psh.peek())) {
            idx2++;
            psh.pop();
        }

        // 如果栈不为空，则说明不是合法的弹出序列
        if(!psh.isEmpty()) {
            System.out.println(false);
            return;
        }

        System.out.println(true);
    }
}
