package hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class LargestRectangleInHistogram {
    /**
     * 使用栈进行存储数据
     * @param heights
     * @return
     */
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : heights[i]);
//            if(s.isEmpty() || h >= heights[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }

    /**
     * 思路：使用栈
     * @param heights
     * @return
     */
//    public int largestRectangleArea(int[] heights) {
//        Deque<Integer> deque = new LinkedList<>();
//        int area = 0;
//        for (int i = 0; i <= heights.length; i++) {
//            int h = i == heights.length ? 0 : heights[i];
//            if (deque.isEmpty() || h >= heights[deque.getFirst()]) {
//                deque.addFirst(i);
//            } else {
//                int tmp = deque.removeFirst();
//                area = Math.max(area, heights[tmp] * (deque.isEmpty() ? i : i - deque.getFirst() - 1));
//                i--;
//            }
//        }
//        return area;
//    }

//    /**
//     * 思路：优先找出各个索引的界限，然后计算最大值
//     * @param heights
//     * @return
//     */
//    public int largestRectangleArea(int[] heights) {
//        if (heights.length == 0) return 0;
//        int[] lessLeft = new int[heights.length];
//        int[] moreRight = new int[heights.length];
//        //设置初始值
//        lessLeft[0] = -1;
//        moreRight[heights.length - 1] = heights.length;
//        for (int i = 1; i < heights.length; i++) {
//            int p = i - 1;
//            while (p > -1 && heights[p] >= heights[i]) {
//                //使用前面已经存储好的边界
//                p = lessLeft[p];
//            }
//            lessLeft[i] = p;
//        }
//        for (int i = heights.length - 2; i >= 0; i--) {
//            int p = i + 1;
//            while (p < heights.length && heights[p] >= heights[i]) {
//                p = moreRight[p];
//            }
//            moreRight[i] = p;
//        }
//        int area = 0;
//        for (int i = 0; i < heights.length; i++) {
//            area = Math.max(area, heights[i] * (moreRight[i] - lessLeft[i] - 1));
//        }
//        return area;
//    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (deque.isEmpty() || heights[i] >= heights[deque.peekFirst()]) deque.addFirst(i);
            else {
                int first = deque.removeFirst();
                if (deque.isEmpty()) max = Math.max(heights[first] * (i - first), max);
                else {max = Math.max(heights[first] * (i - deque.peekFirst()), max); i--;}
            }
        }
        while (deque.size() > 1) {
            int cur = deque.removeFirst();
            int prev = deque.getFirst();
            max = Math.max(max, heights[cur] * (cur - prev + 1));
        }
        if (!deque.isEmpty())
            max = Math.max(max, heights[deque.removeFirst()]);
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{
                1,1,1
        };
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        l.largestRectangleArea(heights);
    }
}
