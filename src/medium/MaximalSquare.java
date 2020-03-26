package medium;

/**
 * @author 潘磊明
 * @date 2019/11/19
 */
public class MaximalSquare {
//    public int maximalSquare(char[][] matrix) {
//        if (matrix.length == 0) return 0;
//        int x = matrix.length;
//        int y = matrix[0].length;
//        int max = 0;
//        int[][] dp = new int[x + 1][y + 1];
//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= y; j++) {
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//                    max = Math.max(dp[i][j], max);
//                }
//            }
//        }
//        return max * max;
//    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        // init
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if (dp[i][0] == 1) max = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            if (dp[0][i] == 1) max = 1;
        }
        //dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i -1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
