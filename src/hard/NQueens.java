package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/6
 */
public class NQueens {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            traversal(result, new ArrayList<String>(), n, i, 1);
//        return result;
//    }
//
//    private void traversal(List<List<String>> result, List<String> list, int n, int offset, int level){
//        list.add(setQueen(n, offset));
//        //判断是否能够攻击到前面已经摆放好的皇后
//        if(canAttack(list, n, offset)) return;
//        if(level == n) {result.add(new ArrayList<>(list)); return;};
//        for (int i = 0; i < n; i++) {
//            traversal(result, list, n, i, level + 1);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    private boolean canAttack(List<String> list, int n, int offset) {
//        int count = 0;
//        for (int i = list.size() - 2; i >= 0; i--){
//            count += 1;
//            String tmp = list.get(i);
//            if (tmp.charAt(offset) == 'Q') return true;
//            if ((offset - count) >= 0 && tmp.charAt(offset - count) == 'Q') return true;
//            if ((offset + count) < n && tmp.charAt(offset + count) == 'Q') return true;
//        }
//        return false;
//    }
//
//    private String setQueen(int n, int offset){
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            if (i == offset) str.append('Q');
//            else str.append('.');
//        }
//        return str.toString();
//    }

//    private int[][] directions = new int[][]{
//            new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}
//    };
//
//    public List<List<String>> solveNQueens(int n) {
//        char[][] tables = init(n);
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            tables[0][i] = 'Q';
//            dfs(result, tables, 0, i);
//            tables[0][i] = '.';
//        }
//        return result;
//    }
//
//    private void dfs(List<List<String>> result, char[][] tables, int row, int col) {
//        if (canAttack(tables, row, col)) return;
//        if (row == tables.length - 1) {result.add(char2List(tables)); return;}
//        for (int i = 0; i < tables.length; i++) {
//            tables[row + 1][i] = 'Q';
//            dfs(result, tables, row + 1, i);
//            tables[row + 1][i] = '.';
//        }
//    }
//
//    /**
//     * 初始化棋盘
//     * @param n
//     * @return
//     */
//    private char[][] init(int n) {
//        char[][] chars = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                chars[i][j] = '.';
//            }
//        }
//        return chars;
//    }
//
//    /**
//     * 判断当前皇后能否攻击到前面的皇后
//     * @param tables
//     * @param p
//     * @param q
//     * @return
//     */
//    private boolean canAttack(char[][] tables, int p, int q) {
//        for (int i = 0; i < p; i++) {
//            for (int j = 0; j < 3; j++) {
//                int row = p + (i + 1) * directions[j][0];
//                int col = q + (i + 1) * directions[j][1];
//                if (row >= 0 && row < tables.length && col >= 0 && col < tables.length)
//                    if (tables[row][col] == 'Q') return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 存储棋盘
//     * @param tables
//     * @return
//     */
//    private List<String> char2List(char[][] tables) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < tables.length; i++) {
//            list.add(new String(tables[i]));
//        }
//        return list;
//    }

    /**
     * 皇后a的位置为（x,y）皇后b的位置为（p,q），如果a，b能攻击到，则满足撇，x - y == p - q,
     * 或者满足列 y == q，或者满足捺 x + y = p + q
     * 攻击范围列，撇，捺分别通过三个Set来存储
     * @param n
     * @return
     */
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        Set<Integer> xy = new HashSet<>();
//        Set<Integer> xy_dif = new HashSet<>();
//        Set<Integer> xy_sum = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            dfs(result, new ArrayList<String>(), new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), n, 0, i);
//        }
//        return result;
//    }
//
//    private void dfs(List<List<String>> result, List<String> list, Set<Integer> xy, Set<Integer> xy_dif,
//                     Set<Integer> xy_sum, int n, int p, int q) {
//
//        // 判断皇后是否能够被攻击到
//        if (xy.contains(q) || xy_dif.contains(p - q) || xy_sum.contains(p + q)) return;
//        xy.add(q);
//        xy_dif.add(p - q);
//        xy_sum.add(p + q);
//        list.add(getQueen(n, q));
//        if (p == n - 1) { result.add(new ArrayList<>(list));}
//        else {
//            for (int i = 0; i < n; i++) {
//                dfs(result, list, xy, xy_dif, xy_sum, n, p + 1, i);
//            }
//        }
//        xy.remove(q);
//        xy_dif.remove(p - q);
//        xy_sum.remove(p + q);
//        list.remove(list.size() - 1);
//    }
//
//    private String getQueen(int n, int q) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < n; i++) {
//            if (i == q) sb.append("Q");
//            else sb.append(".");
//        }
//        return sb.toString();
//    }

    public List<List<String>> solveNQueens(int n) {
        char[][] arrays = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        _solveNQueens(result, arrays, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), 0);
        return result;
    }

    private void _solveNQueens(List<List<String>> result, char[][] arrays,
                               Set<Integer> shu, Set<Integer> pie, Set<Integer> na, int row) {
        if (row == arrays.length) {result.add(toList(arrays)); return;}
        for (int i = 0; i < arrays.length; i++) {
            if (canAttack(shu, pie, na, i, row)) continue;
            shu.add(i); pie.add(i - row); na.add(i + row);
            arrays[row][i] = 'Q';
            _solveNQueens(result, arrays, shu, pie, na, row + 1);
            shu.remove(i); pie.remove(i - row); na.remove(i + row);
            arrays[row][i] = '.';
        }
    }

    private boolean canAttack(Set<Integer> shu, Set<Integer> pie, Set<Integer> na, int i, int p) {
        if (shu.contains(i)) return true;
        if (pie.contains(i - p)) return true;
        if (na.contains(i + p)) return true;
        return false;
    }

    private List<String> toList(char[][] arrays) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arrays[0].length; j++) {
                sb.append(arrays[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        NQueens n = new NQueens();
        n.solveNQueens(4);
    }
}
