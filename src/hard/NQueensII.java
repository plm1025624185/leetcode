package hard;

/**
 * @author 潘磊明
 * @date 2019/12/2
 */
public class NQueensII {
    private int size;
    private int count;

    private void solve(int row, int ld, int rd) {
        String brow = Integer.toBinaryString(row);
        String bld = Integer.toBinaryString(ld);
        String brd = Integer.toBinaryString(rd);
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        String bpos = Integer.toBinaryString(pos);
        while (pos != 0) {
            int p = pos & (-pos);
            String bp = Integer.toBinaryString(p);
            pos -= p; // pos &= pos - 1;
            bpos = Integer.toBinaryString(pos);
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        String b = Integer.toBinaryString(size);
        solve(0, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        NQueensII n = new NQueensII();
        n.totalNQueens(4);
    }
}
