package easy;

/**
 * @author 潘磊明
 * @date 2019/10/18
 */
public class MoveZeros {
//    public void moveZeroes(int[] nums) {
//            int i = 0, j = -1;
//            while (i < nums.length) {
//                if (nums[i] == 0) {
//                    j = j == -1 ? j = i : j++;
//                }else if (j != -1) {
//                    int tmp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = tmp;
//                    j++;
//                }
//                i++;
//            }
//    }

//    public void moveZeroes(int[] nums) {
//        int j = -1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == 0) {
//                j = j == -1 ? j = i : j++;
//            }else if (j != -1 ){
//                swap(nums, i, j);
//                j++;
//            }
//        }
//    }

//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

//    public void moveZeroes(int[] nums) {
//        int tmp = -1; //记录第一个0的索引
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == 0) {
//                tmp = tmp == -1 ? i : tmp;
//            } else if (tmp != -1) {
//                //非0与0进行交换，交换后加1
//                int val = nums[i];
//                nums[i] = nums[tmp];
//                nums[tmp] = val;
//                tmp++;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        int i = -1, j = -1;
        while (++j < nums.length) {
            if (nums[j] == 0) {i = j; break;}
        }
        if (i == -1) return;
        while (++j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }

}
