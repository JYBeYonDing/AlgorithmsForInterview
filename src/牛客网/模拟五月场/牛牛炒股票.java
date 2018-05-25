package 牛客网.模拟五月场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/25 16:14.
 * 链接：https://www.nowcoder.com/questionTerminal/777c3d8f3c764e1da46a7b7f3551343b
 来源：牛客网

 牛牛得知了一些股票今天买入的价格和明天卖出的价格，他找犇犇老师借了一笔钱，现在他想知道他最多能赚多少钱。
 输入描述:
 每个输入包含一个测试用例。
 输入的第一行包括两个正整数,表示股票的种数N(1<=N<=1000)和牛牛借的钱数M(1<=M<=1000)。
 接下来N行，每行包含两个正整数，表示这只股票每一股的买入价X(1<=X<=1000)和卖出价Y(1<=Y<=2000)。
 每只股票可以买入多股，但必须是整数。


 输出描述:
 输出一个整数表示牛牛最多能赚的钱数。
 示例1
 输入
3 5
3 6
2 3
1 1
 输出
 4

 没有AC，报错，不知道什么原因

 */
public class 牛牛炒股票 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);

        int[] cost = new int[N];
        int[] value = new int[N];
        for(int i =0 ; i<N;i++) {
            ss = sc.nextLine().split(" ");
            cost[i] = Integer.parseInt(ss[0]);
            value[i] = Integer.parseInt(ss[1]);
        }
        int maxVal = solutionDP(M, cost, value);
        System.out.println(maxVal-M);

    }

    /**
     * 递归
     */
    private static int solution(int m, int[] cost, int[] value) {
        return rec(m, cost.length-1, cost, value);
    }

    private static int rec(int m, int i, int[] cost, int[] value) {
        if (i < 0 || m<cost[i]) {// 已经看完了所有的股票，或者剩余的钱不够买这个股票则返回0
            return 0;
        }
        int val1 = rec(m - cost[i], i, cost, value) + value[i];// 买cost[[i]的股票
        int val2 = rec(m, i - 1, cost, value);//不买cost[i]的股票
        return Math.max(val1, val2);
    }

    private static int solutionDP(int m, int[] cost, int[] value) {
        int[][] dp = new int[m + 1][cost.length];
        for(int i = 0;i<=m;i++) {
            if (i >= cost[0]) {
                dp[i][0] = i / cost[0] * value[0];
            }
        }

        for(int j = 1; j<cost.length;j++) {
            for(int i = 1;i<=m;i++) {
                int val1 = 0;
                int val2 = 0;
                if (i >= cost[j]) {
                    val1 = dp[i - cost[j]][j] + value[j];
                }
                val2 = dp[i][j - 1];
                dp[i][j] = Math.max(val1, val2);
            }
        }
        return dp[m][cost.length - 1];
    }

}
