package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/1
 */
public class NumberOfIslands {
    /**
     * DFS
     * @param grid
     * @return
     */
//    public int numIslands(char[][] grid) {
//        if (grid.length <= 0) return 0;
//        int num = 0;
////        Set<String> visited = new HashSet<>();
//        int length = grid.length;
//        int height = grid[0].length;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                if (grid[i][j] == '1') {
//                    DFS(grid, i, j, length, height);
//                    num++;
//                }
//            }
//        }
//        return num;
//    }
//
//    public void DFS(char[][] grid, int i, int j, int length, int height){
//        if (i < 0 || j < 0 || i > length - 1 || j > height - 1 || grid[i][j] == '0') return;
//        grid[i][j] = '0';
//        DFS(grid, i - 1, j, length, height);
//        DFS(grid, i + 1, j, length, height);
//        DFS(grid, i, j - 1, length, height);
//        DFS(grid, i, j + 1, length, height);
//    }

//    int[][] directions = new int[][] {
//            new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}
//    };

    private int[][] directions = new int[][] {
            new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}
    };

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        //超出岛屿范围
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1) return;
        //访问过就返回
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k = 0; k < directions.length; k++) {
            dfs(grid, i + directions[k][0], j + directions[k][1]);
        }
    }

}
