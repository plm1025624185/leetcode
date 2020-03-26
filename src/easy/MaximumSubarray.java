package easy;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        for (int k = 1; k < nums.length; k++) {
//            nums[k] = Math.max(nums[k], nums[k] + nums[k - 1]);
//            max = Math.max(max, nums[k]);
//        }
//        return max;
//    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
