package easy;

/**
 * @author 潘磊明
 * @date 2019/11/3
 */
public class BestTimeToBuyAndSellStockII {
//    public int maxProfit(int[] prices) {
//        int profit = 0, i = 0;
//        while (i < prices.length) {
//            // find next local minimum
//            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
//            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
//            // find next local maximum
//            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
//            profit += i < prices.length ? prices[i++] - min : 0;
//        }
//        return profit;
//    }

//    public int maxProfit(int[] prices) {
//        int max = 0;
//        int tmp = -1;
//        int i = 0;
//        while (i < prices.length - 1){
//            if (tmp == -1 && prices[i] < prices[i + 1]) {
//                tmp = i;
//            }else if (tmp != -1 && prices[i] > prices[i + 1]) {
//                max += prices[i] - prices[tmp];
//                tmp = -1;
//            }
//            i++;
//        }
//        if (tmp != -1 && tmp != prices.length - 1 && prices[prices.length - 1] > prices[tmp])
//            max += prices[prices.length - 1] - prices[tmp];
//        return max;
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        /**
//         * 状态方程，一维代表天数，二维代表买入卖出，0代表持有股票，1代表没有持有股票
//         */
//        int[][] dp = new int[prices.length][2];
//        //设置初始值
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//        }
//        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int dp_i_0 = -prices[0];
//        int dp_i_1 = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int tmp = Math.max(dp_i_0, dp_i_1 - prices[i]);
//            dp_i_1 = Math.max(dp_i_1, dp_i_0 + prices[i]);
//            dp_i_0 = tmp;
//        }
//        return Math.max(dp_i_0, dp_i_1);
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        // 0为买入 1为卖出
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
//        }
//        return dp[prices.length - 1][1];
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int dp_i_0 = -prices[0];
//        int dp_i_1 = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int tmp = dp_i_0;
//            dp_i_0 = Math.max(dp_i_0, dp_i_1 - prices[i]);
//            dp_i_1 = Math.max(dp_i_1, tmp + prices[i]);
//        }
//        return dp_i_1;
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int[][] dp = new int[prices.length][2];
//        //init
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i][0] + prices[i], dp[i - 1][1]);
//        }
//        return dp[prices.length - 1][1];
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int dp_i_0 = -prices[0], dp_i_1 = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int tmp = dp_i_0;
//            dp_i_0 = Math.max(dp_i_1 - prices[i], dp_i_0);
//            dp_i_1 = Math.max(dp_i_1, tmp + prices[i]);
//        }
//        return dp_i_1;
//    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
