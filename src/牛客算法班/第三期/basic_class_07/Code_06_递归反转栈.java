package 牛客算法班.第三期.basic_class_07;

import java.util.Stack;

public class Code_06_递归反转栈 {

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);// 得到并移除栈底元素
		reverse(stack);
		stack.push(i);
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

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

}
