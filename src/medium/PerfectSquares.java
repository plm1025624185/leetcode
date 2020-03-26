package medium;

/**
 * @author 潘磊明
 * @date 2020/1/23
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int i = 2; i < n + 1; i++) {
            for (int j = (int)Math.sqrt(i); j >= 1; j--) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
