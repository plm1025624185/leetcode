package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2020/1/30
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
