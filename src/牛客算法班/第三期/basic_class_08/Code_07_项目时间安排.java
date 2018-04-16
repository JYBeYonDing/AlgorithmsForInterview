package 牛客算法班.第三期.basic_class_08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲， 会议室不能同时容纳两个项目
 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
 组， 里面 是一个个具体的项目)， 你来安排宣讲的日程， 要求会
 议室进行 的宣讲的场次最多。 返回这个最多的宣讲场次。

 贪心
 */
public class Code_07_项目时间安排 {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	/**
	 * 按哪个早结束来安排
	 */
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	/**
	 *
	 * @param programs 项目数组
	 * @param cur 当前时刻
	 * @return 完成的最大项目数
	 */
	public static int bestArrange(Program[] programs, int cur) {
		Arrays.sort(programs, new ProgramComparator());//也可以用堆来做
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (cur <= programs[i].start) {
				result++;
				cur = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
