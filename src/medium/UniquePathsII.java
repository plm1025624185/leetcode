package medium;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class UniquePathsII {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid[0].length;
//        int n = obstacleGrid.length;
//        int[] paths = new int[m];
//        // init path
//        for (int i = 0; i < m; i++) {
//            if (obstacleGrid[0][i] == 1) paths[i] = 0;
//            else if (i == 0) paths[i] = 1;
//            else paths[i] = Math.min(paths[i - 1], 1);
//        }
//        // DP程序
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (obstacleGrid[i][j] == 1) paths[j] = 0;
//                else if (j == 0) paths[j] = Math.min(paths[j], 1);
//                else paths[j] = paths[j] + paths[j - 1];
//            }
//        }
//        return paths[m - 1];
//    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid.length == 0) return 0;
//        int row = obstacleGrid.length;
//        int col = obstacleGrid[0].length;
//        int[][] dp = new int[row][col];
//        //init
//        int tmp = 0;
//        for (int i = 0; i < row; i++) {
//            tmp += obstacleGrid[i][0];
//            dp[i][0] = tmp == 0 ? 1 : 0;
//        }
//        tmp = 0;
//        for (int i = 0; i < col; i++) {
//            tmp += obstacleGrid[0][i];
//            dp[0][i] = tmp == 0 ? 1 : 0;
//        }
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
//            }
//        }
//        return dp[row - 1][col - 1];
//    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid.length == 0) return 0;
//        int row = obstacleGrid.length;
//        int col = obstacleGrid[0].length;
//        int[] dp = new int[col + 1];
//        //init
//        int tmp = 0;
//        for (int i = 1; i < col + 1; i++) {
//            tmp += obstacleGrid[0][i - 1];
//            dp[i] = tmp == 0 ? 1 : 0;
//        }
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col + 1; j++) {
//                dp[j] = obstacleGrid[i][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
//            }
//        }
//        return dp[col];
//    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) { return 0; }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] == 0 ? 0 : obstacleGrid[i][0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] == 0 ? 0 : obstacleGrid[0][i] == 1 ? 0 : 1;
        //dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n -1];
    }
}
