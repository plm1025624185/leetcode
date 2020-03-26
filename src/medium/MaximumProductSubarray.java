package medium;

/**
 * @author 潘磊明
 * @date 2019/11/12
 */
public class MaximumProductSubarray {
//    public int maxProduct(int[] nums) {
//        int max = nums[0];
//        int[] minNums = new int[nums.length];
//        int[] maxNums = new int[nums.length];
//        minNums[0] = nums[0];
//        maxNums[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < 0) {
//                minNums[i] = Math.min(nums[i] * maxNums[i - 1], nums[i]);
//                maxNums[i] = Math.max(nums[i] * minNums[i - 1], nums[i]);
//            }else {
//                minNums[i] = Math.min(nums[i] * minNums[i - 1], nums[i]);
//                maxNums[i] = Math.max(nums[i] * maxNums[i - 1], nums[i]);
//            }
//            max = Math.max(max, maxNums[i]);
//        }
//        return max;
//    }

    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(Math.min(nums[i], nums[i] * min[i - 1]), nums[i] * max[i - 1]);
            max[i] = Math.max(Math.max(nums[i], nums[i] * max[i - 1]), nums[i] * min[i - 1]);
            maxValue = Math.max(maxValue, max[i]);
        }
        return maxValue;
    }

}
