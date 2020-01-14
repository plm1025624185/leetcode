package medium;

/**
 * @author 潘磊明
 * @date 2020/1/14
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int colLength = matrix[0].length;
        int leftrow = 0, leftcol = 0, rightrow = matrix.length - 1, rightcol = matrix[0].length - 1;
        while (total(leftrow, leftcol, colLength) <= total(rightrow, rightcol, colLength)) {
            int mid = (total(leftrow, leftcol, colLength) + total(rightrow, rightcol, colLength)) / 2;
            int[] midArray = divide(mid, colLength);
            if (matrix[midArray[0]][midArray[1]] == target) return true;
            else if (matrix[midArray[0]][midArray[1]] < target) {
                if (midArray[1] == colLength - 1) {
                    leftrow = midArray[0] + 1;
                    leftcol = 0;
                } else {
                    leftrow = midArray[0];
                    leftcol = midArray[1] + 1;
                }
            } else {
                if (midArray[1] == 0) {
                    rightrow = midArray[0] - 1;
                    rightcol = colLength - 1;
                } else {
                    rightrow = midArray[0];
                    rightcol = midArray[1] - 1;
                }
            }
        }
        return false;
    }

    private int total(int row, int col, int colLength) {
        return row * colLength + col;
    }

    private int[] divide(int total, int colLength) {
        int row = total / colLength;
        int col = total % colLength;
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,50}
        };
        SearchA2DMatrix s = new SearchA2DMatrix();
        s.searchMatrix(matrix, 3);
    }
}
