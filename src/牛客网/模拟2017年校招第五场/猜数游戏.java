package 牛客网.模拟2017年校招第五场;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/17 18:09.
 * 牛牛和羊羊在玩一个有趣的猜数游戏。
 * 在这个游戏中,牛牛玩家选择一个正整数,羊羊根据已给的提示猜这个数字。
 * 第i个提示是"Y"或者"N",表示牛牛选择的数是否是i的倍数。
 * 例如,如果提示是"YYNYY",它表示这个数使1,2,4,5的倍数,但不是3的倍数。
 * 注意到一些提示会出现错误。例如: 提示"NYYY"是错误的,因为所有的整数都是1的倍数,所以起始元素肯定不会是"N"。
 * 此外,例如"YNNY"的提示也是错误的,因为结果不可能是4的倍数但不是2的倍数。
 * 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
 * 例如 n = 5:
 * 合法的提示有:
 * YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
 * YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
 * 所以输出12
 * 输入描述:
 * 输入包括一个整数n(1 ≤ n ≤ 10^6),表示已给提示的长度。
 * <p>
 * 输出描述:
 * 输出一个整数,表示合法的提示个数。因为答案可能会很大,所以输出对于1000000007的模
 * <p>
 * 输入例子1:
 * 5
 * <p>
 * 输出例子1:
 * 12
 */
public class 猜数游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    /**
     * 别人的思路
     * 链接：https://www.nowcoder.com/questionTerminal/0a5b316cfe9d4c4ba89c6c57a1ee516e
     * 来源：牛客网
     * 首先运用动态规划的思想
     * 首先我们分析，dp[i]表示前i个数的合法个数
     * 当第i个数是素数的时候，前面除了1都没有能除尽的，所以这个位置可以随便选Y或N,所以dp[i] = dp[i-1]
     * 当第i个数不是素数的幂次，比如6，10这种数，那么他们的情况实际上是被前面的数所决定的，对6来说，如果2，3为YY,那么6必然是Y，其他情况6必须是N,所以dp[i] = dp[i-1]
     * 当第i个数是素数的幂次的时候，也就是2，4，8，16这种数，这时候情况就复杂了。假设现在有2，4，8，那么有多少种情况呢，我们仔细分析也能找出规律
     * YYY,YNN,NNN，YYN就这四种情况
     * 对于2，4
     * YN,YY,NN三种情况
     * 我们发现实际上也是有规律的，首先都能或者都不能两种，然后就是从左到右添加Y：
     * YNN,YYN。
     * 所以对于这种情况，我们得出规律，如果有n个幂次，就有n+1种可行的情况。
     * <p>
     * 分析完之后，我们就可以得出计算方法，对于12：
     * 2，4，8这三个数是幂次，有4中可能
     * 3，9 这两个数幂次，有三种可能
     * 5，7，11，分别是两种可能
     * 其他的数都由其他数决定
     * 所以最后结果就是43222
     * <p>
     * 所以我们思考一下，最后就变成了找素数和素数幂次的个数了。
     */
    private static long solution(int n) {
        long ans = 1;
        boolean[] visited = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (visited[i])
                continue;
            for (int j = 2 * i; j <= n; j += i)
                visited[j] = true;
            int count = 0;
            long k = i;//int会溢出
            while (k <= n) {
                k *= i;// i的幂次
                count++;// 记录i的最高幂次
            }
            ans = ans * (count + 1) % 1000000007;
        }
        return ans;
    }
}
