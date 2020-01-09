package medium;

/**
 * @author 潘磊明
 * @date 2019/11/4
 */
public class Minesweeper {
//    public char[][] updateBoard(char[][] board, int[] click) {
//        // 如果点到雷就返回
//        if (board[click[0]][click[1]] == 'M') {
//            board[click[0]][click[1]] = 'X';
//            return board;
//        }
//        // 否则进行遍历
//        dfs(board, click[0], click[1]);
//        return board;
//    }
//
//    private void dfs(char[][] board, int i, int j){
//        int width = board.length;
//        int height = board[0].length;
//        if (i < 0 || i > width - 1 || j < 0 || j > height - 1 || board[i][j] != 'E') return;
//        // 周围没有雷就进行深度遍历
//        if (!surrentMine(board, i, j, width, height)) {
//            dfs(board, i - 1, j - 1);
//            dfs(board, i - 1, j);
//            dfs(board, i - 1, j + 1);
//            dfs(board, i, j - 1);
//            dfs(board, i, j + 1);
//            dfs(board, i + 1, j - 1);
//            dfs(board, i + 1, j);
//            dfs(board, i + 1, j + 1);
//        }
//    }
//
//    /**
//     * 判断周围是否有雷
//     * @param board
//     * @param i
//     * @param j
//     * @return
//     */
//    private boolean surrentMine(char[][] board, int i, int j, int width, int height) {
//        int count = 48; // 周围地雷数量
//        if (i - 1 > -1 && j - 1 > -1 && board[i - 1][j - 1] == 'M') count++;
//        if (i - 1 > -1 && board[i - 1][j] == 'M') count++;
//        if (i - 1 > -1 && j + 1 < height && board[i - 1][j + 1] == 'M') count++;
//        if (j - 1 > -1 && board[i][j - 1] == 'M') count++;
//        if (i + 1 < width && j - 1 > -1 && board[i + 1][j - 1] == 'M') count++;
//        if (j + 1 < height && board[i][j + 1] == 'M') count++;
//        if (i + 1 <width && j + 1 < height && board[i + 1][j + 1] == 'M') count++;
//        if (i + 1 < width && board[i + 1][j] == 'M') count++;
//        if (count > 48) {
//            board[i][j] = (char)count;
//            return true;
//        } else {
//            board[i][j] = 'B';
//            return false;
//        }
//    }

    private int[][] directions = new int[][] {
            new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1},
            new int[]{0, -1}, new int[]{0, 1},
            new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        if (board[r][c] == 'M') {board[r][c] = 'X'; return board;}
        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        int rowLength = board.length;
        int colLength = board[0].length;
        //超出范围
        if (row < 0 || row > rowLength - 1 || col < 0 || col > colLength - 1) return;
        //不为未挖出的方块
        if (board[row][col] != 'E') return;
        char c = click(board, row, col);
        board[row][col] = c;
        if (c != 'B') return;
        for (int i = 0; i < directions.length; i++) {
            dfs(board, row + directions[i][0], col + directions[i][1]);
        }
    }

    private char click(char[][] board, int row, int col) {
        int count = 0;
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < directions.length; i++) {
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if (x < 0 || x > rowLength - 1 || y < 0 || y > colLength - 1) continue;
            if (board[x][y] == 'M') count++;
        }
        if (count == 0) return 'B';
        else return (char)('0' + count);
    }
}
