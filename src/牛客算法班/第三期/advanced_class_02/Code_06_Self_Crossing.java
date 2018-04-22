package 牛客算法班.第三期.advanced_class_02;

/**
 * 一个人开始在(0,0)， 总是第一次走向上方， 第二次走向左方， 第三次走向下方，
 第四次走向右方， 第五次走向上方， 第六次走向左方， 第七次走向下方， 第八
 次走向右方， 第九次走向上方...依次走下去。
 给定一个数组arr， arr[i]表示第i次走的步数。
 请返回， 按照数组的步数走， 会不会让走过的路径交叉在一起。

 扣细节
 第三期 第二章1:50
 */
public class Code_06_Self_Crossing {

	public static boolean isSelfCrossing(int[] x) {
		if (x == null || x.length < 4) {
			return false;
		}
		if ((x.length > 3 && x[2] <= x[0] && x[3] >= x[1])
				||
				(x.length > 4 &&
						((x[3] <= x[1] && x[4] >= x[2]) || (x[3] == x[1] && x[0] + x[4] >= x[2])))) {
			return true;
		}
		// i从5开始是为了防止后面的i-5越界
		for (int i = 5; i < x.length; i++) {
			if (x[i - 1] <= x[i - 3] &&
					((x[i] >= x[i - 2])
							||
							(x[i - 2] >= x[i - 4] && x[i - 5] + x[i - 1] >= x[i - 3] && x[i - 4] + x[i] >= x[i - 2]))) {
				return true;
			}
		}
		return false;
	}

}
