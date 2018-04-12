package 程序员面试指南.栈和队列.getMin的栈;

import java.util.ArrayDeque;

/**
 *
 */
public class GetMinStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public int pop() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("数据栈为空");
        }
        int value = this.stack.pop();
        if (value == this.getMin()) {
            this.minStack.pop();
        }
        return value;
    }

    public void push(int num) {
        stack.push(num);
        if (minStack.isEmpty() || num<=minStack.peekLast()) {
            minStack.push(num);
        }
    }

    public int getMin() {
        return minStack.peekLast();
    }

}
