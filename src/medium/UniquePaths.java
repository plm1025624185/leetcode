package medium;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class UniquePaths {
//    public int uniquePaths(int m, int n) {
//        int[][] paths = new int[m][n];
//        // init path
//        for (int i = 0; i < m; i++) paths[i][0] = 1;
//        for (int i = 0; i < n; i++) paths[0][i] = 1;
//        // 动态规划方程
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
//            }
//        }
//        return paths[m - 1][n - 1];
//    }

//    /**
//     * 使用一维数组
//     * @param m
//     * @param n
//     * @return
//     */
//    public int uniquePaths(int m, int n) {
//        int[] paths = new int[m];
//        // init path
//        for (int i = 0; i < m; i++) paths[i] = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                paths[j] = paths[j] + paths[j - 1];
//            }
//        }
//        return paths[m - 1];
//    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        // init
//        for (int i = 0; i < m; i++) dp[i][0] = 1;
//        for (int i = 0; i < n; i++) dp[0][i] = 1;
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //init
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
