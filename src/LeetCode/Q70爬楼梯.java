package LeetCode;

/**
 * Created by 杨杰 on 2018/7/9 20:06.
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 注意：给定 n 是一个正整数。
 示例 1：
 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 步 + 1 步
 2.  2 步
 */
public class Q70爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int f1 = 1;
        int f2 = 2;
        for(int i=3;i<=n;i++) {
            int temp = f2;
            f2 = f1+f2;
            f1 = temp;
        }
        return f2;
    }
}
