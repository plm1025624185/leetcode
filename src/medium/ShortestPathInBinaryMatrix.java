package medium;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/28
 */
public class ShortestPathInBinaryMatrix {
    /**
     * BFS
     * @param grid
     * @return
     */
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        int n = grid.length;
//        int[][] directions = new int[][]{
//                new int[]{-1, 0}, new int[]{-1, -1}, new int[]{-1, 1}, new int[]{0, -1}, new int[]{0, 1},
//                new int[]{1, -1}, new int[]{1, 0}, new int[]{1,1}
//        };
//        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
//        Deque<Point> deque = new LinkedList<>();
//        deque.add(new Point(0, 0));
//        int step = 0;
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            while (size > 0 ) {
//                Point point = deque.removeFirst();
//                if (point.x == n - 1 && point.y == n - 1) return step + 1;
//                if(grid[point.x][point.y] != 1) {
//                    grid[point.x][point.y] = 1;
//                    for (int i = 0; i < directions.length; i++) {
//                        int nx = point.x + directions[i][0];
//                        int ny = point.y + directions[i][1];
//                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) deque.addLast(new Point(nx, ny));
//                    }
//                }
//                size--;
//            }
//            step++;
//        }
//        return -1;
//    }

    /**
     * 双向BFS
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
        int[][] directions = new int[][]{
            new int[]{-1, 0}, new int[]{-1, -1}, new int[]{-1, 1}, new int[]{0, -1}, new int[]{0, 1},
            new int[]{1, -1}, new int[]{1, 0}, new int[]{1,1}
        };
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add("0@0");
        int n = grid.length - 1;
        endSet.add(n + "@" + n);
        int step = 0;
        //BFS
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //首先扩散元素少的
            if (beginSet.size() > endSet.size()) {
                Set<String> map = beginSet;
                beginSet = endSet;
                endSet = map;
            }
            //开始扩散
            Set<String> tmp = new HashSet<>();
            for (String p : beginSet) {
                if (endSet.contains(p)) return step + 1;
                String[] arr = p.split("@");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                grid[x][y] = 1; //设置为1表示已经走过
                for (int i = 0; i < directions.length; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid.length && grid[nx][ny] == 0 && grid[nx][ny] == 0) {
                        tmp.add(nx + "@" + ny);
                    }
                }
            }
            step++;
            beginSet = tmp;
        }
        return -1;
    }

    /**
     * A*
     * @param grid
     * @return
     */
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 0) return -1;
//        //估值函数
//        Comparator<Point> comparator = new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return o1.x * o1.x + o1.y * o1.y - o2.x * o2.x - o2.y * o2.y;
//            }
//        };
//        //使用优先队列进行存储节点
//        PriorityQueue pq = new PriorityQueue(comparator);
//        pq.add(new Point(0, 0));
//        int step = 0;
//        while (!pq.isEmpty()) {
//
//        }
//    }

    class Point {
        int x = 0;
        int y = 0;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return x + "@" + y;
        }
    }
}
