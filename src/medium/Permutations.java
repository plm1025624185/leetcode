package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/10/27
 */
public class Permutations {

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        traversal(result, new ArrayList<Integer>(), nums);
//        return result;
//    }
//
//    private void traversal(List<List<Integer>> result, List<Integer> list, int[] nums){
//        if (list.size() == nums.length) {
//            result.add(new ArrayList<>(list));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (list.contains(nums[i])) continue;
//                list.add(nums[i]);
//                traversal(result, list, nums);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        _permute(result, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
        return result;
    }

    public void _permute(List<List<Integer>> result, List<Integer> list, Set<Integer> visited, int[] nums) {
        if (list.size() == nums.length) result.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                if (visited.contains(value)) continue;
                list.add(value);
                visited.add(value);
                _permute(result, list, visited, nums);
                visited.remove(value);
                list.remove(list.size() - 1);
            }
        }
    }
}
