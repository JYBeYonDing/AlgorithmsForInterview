package 牛客算法班.第三期.advanced_class_05;

import java.util.Arrays;

/**
 * 你的王国里有n条龙， 你希望雇佣一些勇士把它们杀死， 王国里一共有m个骑士
 可以雇佣。 假定， 一个能力值为x的骑士可以打败战斗力不超过x的恶龙， 且
 需要支付x个金币。 已知勇士可以重复雇佣， 且重复雇佣需要重复支付金币，
 请求出打败所有的恶龙需要的最小金币数目。 例如，你的王国里有三条龙，
 战斗力分别为10， 11， 20， 同时有三个勇士可以雇佣， 能力值分别为
 20,12,30， 最省钱的方式是能力值12的勇士攻击战斗力10的龙， 能力值12的勇
 士攻击战斗力11的龙， 能力值20的勇士攻击战斗力20的龙， 总共付出44金币。
 进阶：
 一条龙可以被勇士合力杀死，求付出的金币数
 举例：
 int[] knights = { 2, 10, 5 };
 int[] dragons = { 3, 8, 6 };
 原问题标准下应返回： 25
 进阶的标准下应返回： 22
 */
public class Code_03_Min_Gold {

	public static int minGold1(int[] knights, int[] dragons) {
		Arrays.sort(knights);
		int res = 0;
		for (int i = 0; i < dragons.length; i++) {
			int cost = getMaxLeftmost(knights, dragons[i]);
			if (cost == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			res += cost;
		}
		return res;
	}

	public static int getMaxLeftmost(int[] sortedArr, int dragon) {
		int L = 0;
		int R = sortedArr.length - 1;
		int index = -1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (sortedArr[mid] < dragon) {
				L = mid + 1;
			} else {
				index = mid;
				R = mid - 1;
			}
		}
		return index == -1 ? Integer.MAX_VALUE : sortedArr[index];
	}




	// all values is positive.
	public static int minGold2(int[] knights, int[] dragons) {
		int sum = 0;
		for (int i = 0; i < knights.length; i++) {
			sum += knights[i];
		}
		int[] dp = new int[sum + 1];
		for (int i = 1; i <= sum; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[knights[0]] = knights[0];
		// printArray(dp);
		for (int i = 1; i < knights.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - knights[i] >= 0
						&& dp[j - knights[i]] < Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - knights[i]] + knights[i]);
				}
			}
			// printArray(dp);
		}
		for (int i = dp.length - 2; i >= 0; i--) {
			dp[i] = Math.min(dp[i], dp[i + 1]);
		}
		// printArray(dp);
		int res = 0;
		for (int i = 0; i < dragons.length; i++) {
			int cost = getMaxLeftmost(dp, dragons[i]);
			if (cost == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			res += cost;
		}
		return res;
	}

	public static void printArray(int[] dp) {
		for (int i = 0; i < dp.length; i++) {
			System.out.print((dp[i] == Integer.MAX_VALUE ? "X" : dp[i]) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] knights1 = { 2, 10, 5 };
		int[] dragons1 = { 3, 8, 6 };
		System.out.println(minGold1(knights1, dragons1));

		int[] knights2 = { 2, 10, 5 };
		int[] dragons2 = { 3, 8, 6 };
		System.out.println(minGold2(knights2, dragons2));

	}

}
