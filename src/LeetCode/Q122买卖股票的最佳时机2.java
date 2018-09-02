package LeetCode;

/**
 * Created by James on 2018/9/2 11:41.
 */
public class Q122买卖股票的最佳时机2 {


    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }

        }

        return sum;
    }


    public static void main(String[] args) {
        Q122买卖股票的最佳时机2 gupiao = new Q122买卖股票的最佳时机2();

        System.out.println(gupiao.maxProfit(new int[]{7,6,4,3,1}));
    }
}
