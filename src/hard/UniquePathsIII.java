package hard;

/**
 * @author 潘磊明
 * @date 2020/1/30
 */
public class UniquePathsIII {
    int[][] directions = new int[][]{
            new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}
    };

    private int startX;
    private int startY;
    private int total = 0;
    private int sum = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        init(grid);
        traserval(grid, startX, startY);
        return sum;
    }

    /**
     * 获取所有可以走过的空格
     * @param grid
     * @return
     */
    private void init(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) total++;
                else if (grid[i][j] == 1) {startX = i; startY = j;}
//                else if (grid[i][j] == 2) {endX = i; endY = j;}
            }
        }
    }

    private void traserval(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == -1) return;
        if (grid[x][y] == 2) {
            if (total != 0) return;
            else {sum++; return;}
        }
        for (int i = 0; i < directions.length; i++) {
            grid[x][y] = -1;
            total--;
            traserval(grid, x + directions[i][0], y + directions[i][1]);
            total++;
            grid[x][y] = 0;
        }
    }
}
