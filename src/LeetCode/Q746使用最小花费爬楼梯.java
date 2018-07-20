package LeetCode;

/**
 * Created by 杨杰 on 2018/7/9 20:39.
 */
public class Q746使用最小花费爬楼梯 {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        for(int i=2;i<cost.length;i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
