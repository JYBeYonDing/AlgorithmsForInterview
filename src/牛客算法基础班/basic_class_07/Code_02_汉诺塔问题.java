package 牛客算法基础班.basic_class_07;

public class Code_02_汉诺塔问题 {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	/**
	 * 把 1~n 从 from 移到 to 上
	 * @param n
	 * @param from
	 * @param mid
	 * @param to
	 */
	public static void func(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println("move 1 from " + from + " to " + to);
		} else {
			func(n - 1, from, to, mid);
			System.out.println("move "+ n+ " from " + from + " to " + to);// 把最下面的一个从from移到to
			func(n - 1, mid, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
