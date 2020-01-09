package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        //首先对数组进行排序
//        Arrays.sort(nums);
//        //设置引用变量
//        List<List<Integer>> result = new ArrayList<>();
//        for (int k = 0; k < nums.length - 2; k++) {
//            if (k == 0 || (k > 0 && nums[k] != nums[k-1])) {
//                int i = k + 1, j = nums.length - 1;
//                while (i < j) {
//                    if (nums[i] + nums[j] < -nums[k])
//                        i++;
//                    else if (nums[i] + nums[j] > -nums[k])
//                        j--;
//                    else {
//                        List<Integer> tmp = Arrays.asList(nums[k], nums[i], nums[j]);
//                        result.add(tmp);
//                        while (i < j && nums[i + 1] == nums[i]) i++;
//                        while (i < j && nums[j] == nums[j - 1]) j--;
//                        i++;
//                        j--;
//                    }
//                }
//            }
//        }
//        return result;
//    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            int x = i + 1, y = nums.length - 1;
//            while (x < y) {
//                if (nums[x] + nums[y] == -nums[i]) {
//                    List<Integer> list = Arrays.asList(nums[i], nums[x], nums[y]);
//                    result.add(list);
//                    while (x + 1 < y && nums[x + 1] == nums[x]) x++;
//                    while (y - 1 > x && nums[y - 1] == nums[y]) y--;
//                    x++;y--;
//                }else if(nums[x] + nums[y] < -nums[i]) {
//                    x++;
//                } else {
//                    y--;
//                }
//            }
//            while(i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
//        }
//        return result;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        //对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            while (i < j) {
                if (nums[i] + nums[j] > -nums[k]) j--;
                else if (nums[i] + nums[j] < -nums[k]) i++;
                else {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    //去除重复
                    while (i < j && nums[i + 1] == nums[i]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;j--;
                }
            }
        }
        return result;
    }
}
