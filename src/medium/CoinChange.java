package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/12
 */
public class CoinChange {
    /**
     * 使用递归方程
     * @param coins
     * @param amount
     * @return
     */
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = coins.length - 1; j >= 0; j--) {
//                if (coins[j] <= i)
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = coins.length - 1; j >= 0; j--) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        int[] dp = new int[amount + 1];
//        for (int i = 0; i < dp.length; i++) dp[i] = amount + 1;
//        dp[0] = 0;
//        for (int i = 1; i < amount + 1; i++) {
//            for (int j = coins.length - 1; j >= 0; j--) {
//                if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // init
        for (int i = 1; i < dp.length; i++) dp[i] = amount + 1;
        // dp
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        c.coinChange(new int[]{
                1,2,5
        }, 11);
    }
}
