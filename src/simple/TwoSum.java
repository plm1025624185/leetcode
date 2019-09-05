package simple;

import java.util.Arrays;

/**
 * 在一个整形数组中，找出两个数相加的和与目标值相等，返回这两个数的索引。
 * 可以确定一个整形数组中有且仅有一组符合要求的值，
 */
public class TwoSum {

    /**
     * 双重循环，时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionOne(int[] nums, int target){
        if(nums.length < 2){
            return null;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{
                            i, j
                    };
                }
            }
        }
        return null;
   }

    /**
     * 主体思路：先排序，然后首尾相加：
     * 1.如果相等，找出这两个值在原数组的索引
     * 2.如果大于target，最大值往左移
     * 3.如果小于target，最小值往右移
     *
     * 主要耗时是数组排列上
     * @param nums
     * @param target
     * @return
     */
   public static int[] solutionTwo(int[] nums, int target){
       // 对数组进行从大到小进行排序
       int[] tmpArray = Arrays.copyOf(nums, nums.length);
       Arrays.sort(tmpArray);
       // 获取哪两个数相加为target
       int first = 0;
       int last = nums.length - 1;
       do{
           if (tmpArray[first] + tmpArray[last] == target){
               break;
           }else if(tmpArray[first] + tmpArray[last] < target){
               first++;
           }else{
               last--;
           }
       } while (first != last);
       //搜索这两个数在原数组的索引
       int i = -1, j = -1;
       for(int k = 0; k < nums.length; k++){
           if(nums[k] == tmpArray[first]){
               i = k;
               break;
           }
       }
       for(int k = 0; k < nums.length; k++){
           if(nums[k] == tmpArray[last] && k != i){
               j = k;
               break;
           }
       }
       //判断索引大小，调整顺序
       if(i > j){
           int tmp = i;
           i = j;
           j = tmp;
       }
       return new int[]{
               i, j
       };
   }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 5, 5, 11
        };
        TwoSum.solutionTwo(nums, 9);
    }
}
