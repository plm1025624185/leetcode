package easy;

/**
 * @author 潘磊明
 * @date 2019/11/13
 */
public class BestTimeToBuyAndSellStock {
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        int fir = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            int tmp = prices[i] - fir;
//            max = Math.max(tmp, max);
//            fir = tmp > 0 ? fir : prices[i];
//        }
//        return max;
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int[][] dp = new int[prices.length][2];
//        //init
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
//        }
//        return dp[prices.length - 1][1];
//    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int dp_i_0 = -prices[0], dp_i_1 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, -prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 + prices[i]);
        }
        return dp_i_1;
    }
}
