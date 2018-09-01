package LeetCode;

/**
 * Created by James on 2018/8/30 23:30.
 */
public class Q343整数拆分 {

    public int integerBreak(int n) {


//        int[] memo = new int[n+1];
//        return maxProduct(n,memo);

        //动态规划
        int[] memo = new int[n + 1];
        memo[1]=1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i - 1; j++) {
                memo[i] = Math.max(memo[i], j * memo[i - j]);
                memo[i] = Math.max(memo[i], j * (i - j));
            }
        }

        return memo[n];
    }

    private int maxProduct(int n,int[] memo) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n -1; i++) {
            res = Math.max(res, maxProduct(n - i,memo) * i);
            res = Math.max(res, i * (n - i));
        }
        memo[n] = res;
        return res;
    }


    public static void main(String[] args) {
        Q343整数拆分 zhengshu = new Q343整数拆分();

        System.out.println(zhengshu.integerBreak(10));
        System.out.println();
    }
}
