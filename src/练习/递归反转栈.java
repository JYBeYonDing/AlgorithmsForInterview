package 练习;

import java.util.Stack;

/**
 * Created by 杨杰 on 2018/5/16 8:19.
 */
public class 递归反转栈 {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

    private static void reverse(Stack<Integer> test) {
        if (test.size() == 0) {
            return;
        }
        int bottom = getAndRemoveBottom(test);
        reverse(test);
        test.push(bottom);
    }

    private static int getAndRemoveBottom(Stack<Integer> test) {
        int temp = test.pop();
        if (test.size() == 0) {
            return temp;
        }
        int bottom = getAndRemoveBottom(test);
        test.push(temp);
        return bottom;
    }
}
