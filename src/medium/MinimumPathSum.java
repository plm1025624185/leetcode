package medium;

/**
 * @author 潘磊明
 * @date 2019/11/15
 */
public class MinimumPathSum {

//    public int minPathSum(int[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        int[] dp = new int[col];
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (i == 0 && j ==0) dp[0] = grid[0][0];
//                else if (i == 0) {
//                    dp[j] = dp[j - 1] + grid[i][j];
//                } else if (j == 0) {
//                    dp[0] = dp[0] + grid[i][j];
//                } else {
//                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
//                }
//            }
//        }
//        return dp[col - 1];
//    }

//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        // init
//        dp[0][0] = grid[0][0];
//        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
//        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    private int min = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return min;
    }

    public void dfs(int[][] grid, int x, int y, int curValue) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) return;
        curValue = curValue + grid[x][y];
        if (x == m - 1 && y == n - 1) {min = Math.min(min, curValue); return;}
        dfs(grid, x + 1, y, curValue);
        dfs(grid, x, y + 1, curValue);
    }
}
