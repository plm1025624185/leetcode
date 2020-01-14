package medium;

/**
 * @author 潘磊明
 * @date 2020/1/14
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums[nums.length - 1] < nums[nums.length - 2]) return nums[nums.length - 1];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {left = 1; continue;}
            if (mid == nums.length - 1) {right = nums.length - 2; continue;}
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
