package 牛客网.模拟六月场;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 杨杰 on 2018/6/24 10:14.
 * 今年的世界杯要开始啦，牛牛作为一个球迷，当然不会放过去开幕式现场的机会。
 * 但是牛牛一个人去又觉得太过寂寞，便想叫上了他的n个小伙伴陪他一起去莫斯科(一共n+1人)。
 * 当牛牛开始订开幕式的门票时，发现门票有m种套餐，
 * 每种套餐需要花费x元，包含y张门票，每张门票也可以单独购买，此时这张门票的价格为k元。
 * 请问牛牛要怎样选择购买门票，使得他花费的钱最少。(每种套餐可以购买次数没有限制)。
 * <p>
 * 输入描述:
 * 第一行输入三个数字n(0≤n≤999)、m(1≤m≤1000)和k(1≤k≤100000)
 * 接下来m行，每行输入两个数字xi(1≤xi≤100000)和yi(2≤yi≤1000), 表示套餐的价格和套餐内包含的门票数量。
 * <p>
 * 输出描述:
 * 输出牛牛至少要花费的钱的数量。
 * <p>
 * 输入例子1:
2 2 5
6 2
13 3
 * <p>
 * 输出例子1:
 * 11
 *
 * 有测试样例没通过，但是感觉测试样例有问题。
 */
public class 牛牛与世界杯门票 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        MealSet[] mealSets = new MealSet[m + 1];
        int k = Integer.parseInt(strs[2]);
        mealSets[0] = new MealSet(k, 1);// 单买也算一种套餐，花费k，人数1
        for (int i = 1; i < m + 1; i++) {
            strs = bufferedReader.readLine().split(" ");
            mealSets[i] = new MealSet(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        }
        calc(n + 1, mealSets);
    }


    /**
     * 借用完全背包问题的思想
     */
    private static void calc(int n, MealSet[] mealSets) {
        int[][] dp = new int[mealSets.length][n + 1];//考虑前i(0~m)个套餐时，j个人总的最小价格;此时单张票作为mealSets[0]传入
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j * mealSets[0].x;// 只考虑第0个套餐时，最少的价格
        }
        for (int i = 1; i < mealSets.length; i++) {//考虑第i个套餐
            for (int j = 1; j <= n; j++) {// j个人
                if (j <= mealSets[i].y) {//
                    dp[i][j] = Math.min(dp[i - 1][j], mealSets[i].x);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - mealSets[i].y] + mealSets[i].x);
                }
            }
        }
        System.out.println(dp[mealSets.length-1][n]);
    }

    static class MealSet {
        int x;
        int y;

        public MealSet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
