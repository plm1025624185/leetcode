package easy;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class RemoveDuplicatesFromSortedArray {
//    public int removeDuplicates(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }else {
//            int len = 1;
//            for (int i = 0; i < nums.length - 1;) {
//                int j = i + 1;
//                while (j < nums.length && nums[j] == nums[i]){
//                    j++;
//                }
//                if(j < nums.length){
//                    i = j;
//                    nums[len] = nums[i];
//                    len++;
//                }else{
//                    i++;
//                }
//            }
//            return len;
//        }
//    }

//    public int removeDuplicates(int[] nums) {
//        if (nums.length < 2) return nums.length;
//        int len = 1;
//        for (int i = 0; i < nums.length - 1;) {
//            int j = i + 1;
//            while (j < nums.length && nums[j] == nums[i]) {
//                j++;
//            }
//            if (j < nums.length) {
//                nums[len++] = nums[j];
//            }
//            i = j;
//        }
//        return len;
//    }

//    /**
//     * 优质代码
//     * @param nums
//     * @return
//     */
//    public int removeDuplicates(int[] nums){
//        if (nums.length < 2) return nums.length;
//        int id = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1]) nums[id++] = nums[i];
//        }
//        return id;
//    }

    public int removeDuplicates(int[] nums) {
        int ind = -1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (ind == -1) ind = i;
                continue;
            }
            if (ind != -1) {
                nums[ind++] = nums[i];
            }
            count++;
        }
        return count;
    }
}
