package LeetCode.Q155最小栈;

import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/4/10 15:45.
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常量时间内检索最小元素的栈。
 * <p>
 * push(x) -- 将元素x推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private ArrayDeque<Integer> data = new ArrayDeque<>();
    private ArrayDeque<Integer> min = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
