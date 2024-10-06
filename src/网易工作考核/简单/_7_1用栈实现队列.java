package 网易工作考核.简单;

import java.util.Scanner;
import java.util.Stack;


/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * <p>
 * int pop() 从队列的开头移除并返回元素
 * <p>
 * int peek() 返回队列开头的元素
 * <p>
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * 注意：返回的的字符串结果需要是小写的格式
 * <p>
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * <p>
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * 输入格式:
 * 第一行输入是操作的序列，即MinStack类之中的成员函数；
 * <p>
 * 第二行输入是成员函数所对应的参数，若没有参数则输入为 []
 * <p>
 * 输出格式:
 * 输出为对应序列中每个操作的返回值
 * <p>
 * 输入样例:
 * 在这里给出一组输入。例如：
 * <p>
 * push,push,peek,pop,empty
 * 1,2,,,
 * 输出样例:
 * 在这里给出相应的输出。例如：
 * <p>
 * null,null,1,1,false
 * 解释:
 * MyQueue myQueue = new MyQueue();
 * <p>
 * myQueue.push(1); // queue is: [1]
 * <p>
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * <p>
 * myQueue.peek(); // return 1
 * <p>
 * myQueue.pop(); // return 1, queue is [2]
 * <p>
 * myQueue.empty(); // return false
 * <p>
 * 提示:
 * 1 <= x <= 9
 * <p>
 * 最多调用 100 次 push、pop、peek 和 empty
 * <p>
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class _7_1用栈实现队列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opts = in.nextLine();
        String params = in.nextLine();
        String[] optList = opts.split(",");
        String[] paramList = params.split(",");
        MyQueue myQueue = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < optList.length; i++) {
            switch (optList[i]) {
                case "push":
                    myQueue.push(Integer.parseInt(paramList[i]));
                    sb.append("null,");
                    break;
                case "pop":
                    sb.append(myQueue.pop()).append(",");
                    break;
                case "peek":
                    sb.append(myQueue.peek()).append(",");
                    break;
                case "empty":
                    sb.append(myQueue.empty()).append(",");
                    break;
                default:
                    break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static class MyQueue {
        // 尾
        private Stack<Integer> stack1;
        // 头
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
