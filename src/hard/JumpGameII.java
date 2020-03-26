package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 潘磊明
 * @date 2019/11/5
 */
public class JumpGameII {
//    public int jump(int[] nums) {
//        int end = 0, maxIndex = 0, jump = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            maxIndex = Math.max(maxIndex, i + nums[i]);
//            if (i == end) {
//                end = maxIndex;
//                jump++;
//            }
//        }
//        return jump;
//    }

//    public int jump(int[] nums) {
//        int step = 0; int end = 0; int maxIndex = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            maxIndex = Math.max(nums[i] + i, maxIndex);
//            if (i == end) {
//                end = maxIndex;
//                step++;
//            }
//        }
//        return step;
//    }

    public int jump(int[] nums) {
        int step = 0, max = 0, maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (i == max) {
                max = maxIndex;
                step++;
            }
        }
        return step;
    }

}
