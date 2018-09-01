package LeetCode;

import java.util.ArrayList;

/**
 * Created by James on 2018/8/31 14:40.
 *
 * https://blog.csdn.net/xuchonghao/article/details/81011133
 *
 * 动态规划
 */
public class Q279完全平方数 {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        ArrayList<Integer> square = generateSquare(n);

        for (int i = 2; i <= n; i++) {

            for (int num : square) {

                if (num > i) {
                    break;
                }

                dp[i] = Math.min(dp[i], 1+dp[i - num]);

            }

        }

        return dp[n];
    }

    private ArrayList<Integer> generateSquare(int n) {
        ArrayList<Integer> res = new ArrayList<>();

        int temp = 0;
        for (int i = 1; (temp = i * i) <= n; i++) {
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args) {
        Q279完全平方数 pingfang = new Q279完全平方数();

        System.out.println(pingfang.numSquares(12));
    }



    // 牛逼的解法，没有看懂
    public int numSquares2(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a < n; a++) {
            for (int b = 0; b * b <= n - a * a; b++) {
                if (a * a + b * b == n) {
                    return (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0);
                }
            }
        }
        return 3;
    }
}
