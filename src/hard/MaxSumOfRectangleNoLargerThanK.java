package hard;

/**
 * @author 潘磊明
 * @date 2020/2/9
 */
public class MaxSumOfRectangleNoLargerThanK {
//    public int maxSumSubmatrix(int[][] matrix, int a) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] dp = new int[m + 1][n + 1];
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i <m; ++i) {
//            for(int j = 0; j < n; ++j) {
//                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
//                if(dp[i + 1][j + 1] <= a) max = Math.max(max, dp[i + 1][j + 1]);
//            }
//        }
//
//        int sum = 0;
//        for(int i = 1; i <= m; ++i) {
//            for(int j = 1; j <= n; ++j) {
//                for(int k = 1; i - k >= 0; ++k) {
//                    for(int l = 1; j - l >= 0; ++l) {
//                        sum = dp[i][j] - dp[i - k][j] - dp[i][j - l] + dp[i - k][j - l];
//                        if(sum <= k) max = Math.max(max, sum);
//                    }
//                }
//            }
//        }
//        return max;
//    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                max = dp[i][j] <= k ? Math.max(max, dp[i][j]) : max;
                if (max == k) return max;
            }
        }
        int sum = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int x = 0; x < i; x++) {
                    for (int y = 0; y < j; y++) {
                        sum = dp[i][j] - dp[x][j] - dp[i][y] + dp[x][y];
                        max = sum <= k ? Math.max(max, sum) : max;
                        if (max == k) return max;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[]{2, 2 ,-1}
        };
        MaxSumOfRectangleNoLargerThanK m = new MaxSumOfRectangleNoLargerThanK();
        m.maxSumSubmatrix(matrix, 3);
    }
}
