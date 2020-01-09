package hard;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 这道暂时还没理解。。。
 * @author 潘磊明
 * @date 2019/10/20
 */
public class TrappingRainWater {
//    public int trap(int[] height) {
//        if (height.length < 3) return 0;
//
//        int ans = 0;
//        int l = 0, r = height.length - 1;
//
//        //获取左右边界
//        while (l < r && height[l] <= height[l + 1]) l++;
//        while (l < r && height[r] <= height[r - 1]) r--;
//
//        //循环获取存储雨滴的大小
//        while (l < r) {
//            int left = height[l];
//            int right = height[r];
//            if (left <= right) {
//                while (l < r && left >= height[++l]) {
//                    ans += left - height[l];
//                }
//            } else {
//                while (l < r && height[--r] <= right) {
//                    ans += right - height[r];
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 使用栈暂时存储
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        Stack<Integer> stack = new Stack<>();
//        int ans = 0, current = 0;
//        for (;current < height.length;){
//            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
//                //如果发现有右边界，就弹出对象，弹出对象的左边界为下面的一个元素
//                int tmp = stack.pop();
//                if(stack.isEmpty()) break;
//                int distance = current - stack.peek() - 1;
//                int h = Math.min(height[current], height[stack.peek()]) - height[tmp];
//                ans += distance * h;
//            }
//            stack.push(current++);
//        }
//        return ans;
//    }


    /**
     * 双指针法
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        int l = 0;
//        int r = height.length - 1;
//        int ans = 0;
//
//        //首先找出左边最大的与右边最大的柱子，这样才能进行蓄水
//        while (l < r && height[l + 1] > height[l]) l++;
//        while (l < r && height[r - 1] > height[r]) r--;
//
//        //计算面积
//        while (l < r) {
//            int left = height[l];
//            int right = height[r];
//            if (left <= right) {
//                while (l < r && left >= height[++l]) {
//                    ans += left - height[l];
//                }
//            } else {
//                while (l < r && right >= height[--r]) {
//                    ans += right - height[r];
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 使用栈
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        Deque<Integer> deque = new LinkedList<>();
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (deque.isEmpty()) deque.addFirst(i);
//            else {
//                while (!deque.isEmpty() && height[deque.getFirst()] <= height[i]) {
//                    int first = deque.removeFirst();
//                    if (!deque.isEmpty()) {
//                        int ht = Math.min(height[i], height[deque.getFirst()]) - height[first];
//                        int wid = i - deque.getFirst() - 1;
//                        max += ht * wid;
//                    }
//                }
//                deque.addFirst(i);
//            }
//        }
//        return max;
//    }

    /**
     * 动态编程
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        if (height.length == 0) return 0;
//        int[] leftMax = new int[height.length];
//        int[] rightMax = new int[height.length];
//        leftMax[0] = height[0];
//        for (int i = 1; i < height.length; i++) leftMax[i] = Math.max(height[i], leftMax[i - 1]);
//        rightMax[height.length - 1] = height[height.length - 1];
//        for (int i = height.length - 2; i >= 0; i--) rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            max += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return max;
//    }

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] > leftMax) leftMax = height[i];
                else max += leftMax - height[i];
                i++;
            } else {
                if (height[j] >= rightMax) rightMax = height[i];
                else max += rightMax - height[i];
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
