package 程序员面试指南.栈和队列.两个栈组成队列;

import java.util.ArrayDeque;

public class MyQueue {
    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();

    public void add(int num) {
        stack1.push(num);
    }

    public int poll(){
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public int peek(){
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.getLast();
    }
}
