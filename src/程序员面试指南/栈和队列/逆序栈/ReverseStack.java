package 程序员面试指南.栈和队列.逆序栈;

import java.util.ArrayDeque;

public class ReverseStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    public void reverse(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }else{
            int botton = getAndRemoveBottonInt(stack);
            reverse(stack);
            stack.push(botton);
        }
    }

    private int getAndRemoveBottonInt(ArrayDeque<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        }else{
            int botton = getAndRemoveBottonInt(stack);
            stack.push(num);
            return botton;
        }
    }

    public static void main(String[] args) {

    }

}
