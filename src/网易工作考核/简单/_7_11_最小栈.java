package 网易工作考核.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_11_最小栈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MinStack minStack = new MinStack();
        String strOpt = in.nextLine();
        String[] opts = strOpt.split(",");
        String numStr = in.next();
        String[] nums = numStr.split(",");
        for (int i = 0; i < opts.length; i++) {
            if (opts[i].equals("push")) {
                minStack.push(Integer.valueOf(nums[i]));
                System.out.print("null");
            } else if (opts[i].equals("getMin")) {
                System.out.print(minStack.minDeque.peek());
            } else if (opts[i].equals("pop")) {
                minStack.pop();
                System.out.print("null");
            } else if (opts[i].equals("top")) {
                System.out.print(minStack.top());
            }
            if (i != opts.length - 1) {
                System.out.print(",");
            }
        }
    }

    public static class MinStack {
        Deque<Integer> deque = new ArrayDeque<>();

        Deque<Integer> minDeque = new ArrayDeque<>();

        public void push(Integer n) {
            deque.push(n);
            if (minDeque.isEmpty() || n < minDeque.peek()) {
                minDeque.push(n);
            } else {
                minDeque.push(minDeque.peek());
            }
        }

        public Integer pop() {
            minDeque.pop();
            return deque.pop();
        }

        public Integer top() {
            return deque.peek();
        }
    }
}
