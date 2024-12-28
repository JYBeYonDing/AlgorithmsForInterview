/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (49.47%)
 * Likes:    2918
 * Dislikes: 0
 * Total Accepted:    933.6K
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(memo==null){
            memo = new int[amount+1];
        }
        if(amount==0){
            return 0;
        }else if(amount<0){
            return -1;
        }
        if(memo[amount]!=0){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int subproblem = coinChange(coins, amount-coin);
            if(subproblem==-1){
                continue;
            }
            res = Math.min(res, subproblem+1);
        }
        memo[amount] = res==Integer.MAX_VALUE?-1:res;
        return memo[amount];
    }
}
// @lc code=end

