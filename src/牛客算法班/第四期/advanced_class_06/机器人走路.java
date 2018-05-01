package 牛客算法班.第四期.advanced_class_06;

/**
 * Created by 杨杰 on 2018/5/1 16:18.
 * N 一共有1~N的位置
 * M 机器人来到的位置
 * P 可以走的步数
 * K 最终停在的位置
 * 返回值： 一共有多少种走法
 */
public class 机器人走路 {

    /**
     * 从M到K经过P步有多少种走法
     */
    public static int ways(int N, int M, int P, int K) {
        if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }
        if (P == 0) {
            return M == K ? 1 : 0;
        }
        int res = 0;
        if (M == 1) {
            res = ways(N, M + 1, P - 1, K);
        } else if (M == N) {
            res = ways(N, M - 1, P - 1, K);
        } else {
            res = ways(N, M + 1, P - 1, K) + ways(N, M - 1, P - 1, K);
        }
        return res;
    }

    //动态规划表画出来后发现就是一个杨辉三角

}
