package 程序员面试指南.栈和队列.栈排序;


import java.util.ArrayDeque;

public class SortStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> help = new ArrayDeque<>();

    public void sort() {
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!help.isEmpty() && temp > help.peekLast()) {
                stack.push(help.pop());
            }
            help.push(temp);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

}
