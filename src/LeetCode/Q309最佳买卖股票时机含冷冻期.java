package LeetCode;

/**
 * Created by James on 2018/9/3 16:07.
 */
public class Q309最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {


        return 0;
    }





    //  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
    public int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
