package org.example.simple;

import java.util.Scanner;
import java.util.*;

/**
 * 用栈实现队列
 * 分数 30
 * 作者 
 * 单位 
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 *
 * int pop() 从队列的开头移除并返回元素
 *
 * int peek() 返回队列开头的元素
 *
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 注意：返回的的字符串结果需要是小写的格式
 *
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 输入格式:
 * 第一行输入是操作的序列，即MinStack类之中的成员函数；
 *
 * 第二行输入是成员函数所对应的参数，若没有参数则输入为 []
 *
 * 输出格式:
 * 输出为对应序列中每个操作的返回值
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * push,push,peek,pop,empty
 * 1,2,,,
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * null,null,1,1,false
 * 解释:
 * MyQueue myQueue = new MyQueue();
 *
 * myQueue.push(1); // queue is: [1]
 *
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 *
 * myQueue.peek(); // return 1
 *
 * myQueue.pop(); // return 1, queue is [2]
 *
 * myQueue.empty(); // return false
 *
 * 提示:
 * 1 <= x <= 9
 *
 * 最多调用 100 次 push、pop、peek 和 empty
 *
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class Simple01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ops = scanner.nextLine();
        String params = scanner.nextLine();

        scanner.close();

        String[] op = ops.split(",");
        //split with -1 to keep empty string
        String[] ps = params.split(",",-1);

        MyQueue queue = new MyQueue();
        List<String> res = new ArrayList<>();
        for (int i = 0; i< op.length; i++) {
            switch (op[i]) {
                case "push":{
                    queue.push(Integer.parseInt(ps[i]));
                    res.add(null);
                    break;
                }
                case "pop": {
                    res.add(String.valueOf(queue.pop()));
                    break;
                }
                case "peek": {
                    res.add(String.valueOf(queue.peek()));
                    break;
                }
                case "empty": {
                    res.add(String.valueOf(queue.empty()));
                    break;
                }
                default: break;
            }
        }

        System.out.println(String.join(",",res));
    }


    static class MyQueue {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        void push(int x) {
            //push to a stack
            a.push(x);
        }

        int pop() {
            //pop from b stack
            if (!b.isEmpty()) {
                return b.pop();
            }
            //a to b
            trans();
            //pop from b stack
            return b.pop();
        }

        int peek() {
            //peek from b stack
            if (!b.isEmpty()) {
                return b.peek();
            }
            //a to b
            trans();
            //peek from b stack
            return b.peek();
        }

        boolean empty() {
            //check if b is empty
            if (!b.isEmpty()) {
                return false;
            }
            //a to b
            trans();
            //check if b is empty
            return b.isEmpty();
        }

        //move all elements from a to b
        private void trans() {
            while (!a.isEmpty()) {
                int x = a.pop();
                b.push(x);
            }
        }
    }
}
