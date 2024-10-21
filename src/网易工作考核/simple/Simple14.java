package org.example.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 最小栈
 * 分数 30
 * 作者 
 * 单位 
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 *
 * void push(int val) 将元素val推入堆栈。
 *
 * void pop() 删除堆栈顶部的元素。
 *
 * int top() 获取堆栈顶部的元素。
 *
 * int getMin() 获取堆栈中的最小元素。
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
 * push,push,push,getMin,pop,top,getMin
 * -2,0,-3,,,,
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * null,null,null,-3,null,0,-2
 * 解释:
 * MinStack minStack = new MinStack();
 *
 * minStack.push(-2);
 *
 * minStack.push(0);
 *
 * minStack.push(-3);
 *
 * minStack.getMin(); --> 返回 -3.
 *
 * minStack.pop();
 *
 * minStack.top(); --> 返回 0.
 *
 * minStack.getMin(); --> 返回 -2.
 *
 * 提示:
 * -231 <= val <= 231 - 1
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 *
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */
public class Simple14 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        String pa = in.nextLine();
        in.close();

        String[] ops = op.split(",");
        String[] pas = pa.split(",",-1);

        MinStack minStack = new MinStack();

        List<String> resultList = new ArrayList<>();
        for(int i = 0; i < ops.length; i++) {
            switch(ops[i]) {
                case "push": {
                    minStack.push(Integer.parseInt(pas[i]));
                    resultList.add("null");
                    break;
                }
                case "pop": {
                    minStack.pop();
                    resultList.add("null");
                    break;
                }
                case "top": {
                    resultList.add(String.valueOf(minStack.top()));
                    break;
                }
                case "getMin": {
                    resultList.add(String.valueOf(minStack.getMin()));
                    break;
                }
                default:
                    break;
            }
        }

        System.out.println(String.join(",", resultList));
    }

    private static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack(){

        }

        void push(int val){
            stack.push(val);
            if(minStack.isEmpty()) {
                minStack.push(stack.peek());
                return;
            }
            if(stack.peek() < minStack.peek()) {
                minStack.push(stack.peek());
            } else {
                minStack.push(minStack.peek());
            }
        }

        void pop() {
            stack.pop();
            minStack.pop();
        }

        int top() {
            return stack.peek();
        }

        int getMin() {
            return minStack.peek();
        }
    }
}
