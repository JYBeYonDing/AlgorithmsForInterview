package 牛客算法班.第三期.advanced_class_06;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 【题目】
 给定一个整型矩阵map， 其中的值只有0和1两种， 求其中全是1
 的所有矩形区域中， 最大的矩形区域为1的数量。
 例如：
 1 1 1 0
 其中， 最大的矩形区域有3个1， 所以返回3。
 再如：
 1 0 1 1
 1 1 1 1
 1 1 1 0
 其中， 最大的矩形区域有6个1， 所以返回6。

 单调栈
 */
public class Code_04_求最大子矩阵的大小 {

	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	/**
	 * 找直方图数组中的最大矩阵
	 * @param height
	 * @return
	 */
	public static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();// 栈中存放下标
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();// 左边界，及底下的东西
				int curArea = (i - k - 1) * height[j];// 以出来的数据作为高能扩的最大值
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		// 结算栈中剩下的位置
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}

}
