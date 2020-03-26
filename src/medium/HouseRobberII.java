package medium;

/**
 * @author 潘磊明
 * @date 2019/11/13
 */
public class HouseRobberII {
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int max = 0, fir = 0, sec = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            max = Math.max(sec, fir + nums[i]);
//            fir = sec;
//            sec = max;
//        }
//        int max1 = 0;
//        fir = 0; sec = 0;
//        for (int i = 1; i < nums.length; i++) {
//            max1 = Math.max(sec, fir + nums[i]);
//            fir = sec;
//            sec = max1;
//        }
//        return Math.max(max, max1);
//    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int begin, int end) {
        int first = nums[begin];
        int second = Math.max(nums[begin + 1], nums[begin]);
        for (int i = begin + 2; i < end; i++) {
            int tmp = Math.max(nums[i] + first, second);
            first = second;
            second = tmp;
        }
        return second;
    }
}
