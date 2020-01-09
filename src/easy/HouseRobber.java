package easy;

/**
 * @author 潘磊明
 * @date 2019/11/12
 */
public class HouseRobber {
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        //状态变量 1为偷 0为不偷
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = nums[0];
//        //dp方程
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
//            dp[i][1] = dp[i - 1][0] + nums[i];
//        }
//        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);
//    }

//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        //状态变量dp代表第i个最大且第i个必偷
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[nums.length - 1];
//    }

//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int first = nums[0];
//        int second = Math.max(nums[1], nums[0]);
//        for (int i = 2; i < nums.length; i++) {
//            int tmp = Math.max(second, first + nums[i]);
//            first = second;
//            second = tmp;
//        }
//        return second;
//    }

    /**
     * 优秀代码
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int first = 0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;
        }
        return second;
    }
}
