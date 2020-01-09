package hard;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 潘磊明
 * @date 2019/11/7
 */
public class SlidingWindowMaximum {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0 || k == 1) return nums;
//        int[] result = new int[nums.length - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        int maxIndex = -1;
//        //初始化
//        for (int i = 0; i < k; i++) {
//            deque.addLast(i);
//            maxIndex = maxIndex == -1 ? i : nums[i] >= nums[maxIndex] ? i : maxIndex;
//        }
//        result[0] = nums[maxIndex];
//        for (int i = 1; i < result.length; i++) {
//            int tp = deque.removeFirst();
//            int cur = k + i - 1;
//            deque.addLast(cur);
//            //判断进来的值是否是最大值，是的话，修改索引保存即可
//            if (nums[maxIndex] <= nums[cur]) {maxIndex = cur; }
//            //判断当前移除的是否是最大值
//            else if (tp == maxIndex) maxIndex = getMaxIndex(nums, cur, k);
//            result[i] = nums[maxIndex];
//        }
//        return result;
//    }
//
//    private int getMaxIndex(int[] nums, int cur, int k){
//        int max = -1;
//        for (int i = 0; i < k; i++) {
//            max = max == -1 ? cur - i : nums[cur - i] > nums[max] ? cur - i : max;
//        }
//        return max;
//    }

    /**
     * 将左右的最大值罗列出来，最后窗口中的最大值就是Math.max(leftMax, rightMax)
     * 解释地址：https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array
     * @param nums
     * @param k
     * @return
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length <= 1 || k == 1) return nums;
//        int[] leftMax = new int[nums.length];
//        int[] rightMax = new int[nums.length];
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length; i++) {
//            leftMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], leftMax[i - 1]);
//            int t = nums.length - 1 - i;
//            rightMax[t] = t == nums.length - 1 || t % k == k -1 ? nums[t] : Math.max(nums[t], rightMax[t + 1]);
//        }
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
//        }
//        return result;
//    }

    /**
     * 双向队列处理
     * @param nums
     * @param k
     * @return
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length * k == 0) return new int[0];
//        if (k == 1) return nums;
//        Deque<Integer> deque = new LinkedList<>();
//        int[] result = new int[nums.length - k + 1];
//        int maxInd = 0;
//        //初始化
//        for (int i = 0; i < k; i++) {
//            cleanDeque(deque, nums, i, k);
//            deque.addLast(i);
//            if (nums[i] >= nums[maxInd]) maxInd = i;
//        }
//        result[0] = nums[maxInd];
//        for (int i = k; i < nums.length; i++) {
//            cleanDeque(deque, nums, i, k);
//            deque.addLast(i);
//            result[i - k + 1] = nums[deque.getFirst()];
//        }
//        return result;
//    }

    /**
     * 清楚掉窗口外的元素，然后将比当前加进来小的直接移除
     * @param deque
     * @param i
     * @param k
     */
//    private void cleanDeque(Deque<Integer> deque, int[] nums, int i, int k) {
//        //移除不在窗口中的
//        while (!deque.isEmpty() && deque.getFirst() == i - k) deque.removeFirst();
//        //移除比当前小的
//        while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) deque.removeLast();
//    }

    /**
     * 使用动态规划
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) return new int[0];
        if (k == 1) return nums;
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], leftMax[i - 1]);
            int t = nums.length - 1 - i;
            rightMax[t] = t == nums.length - 1 || t % k == k - 1 ? nums[t] : Math.max(nums[t], rightMax[t + 1]);
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -7,-8,7,5,7,1,6,0
        };
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.maxSlidingWindow(nums, 5);
    }
}
