package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2020/1/3
 */
public class permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        _permuteUnique(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void _permuteUnique(int[] nums, List<List<Integer>> result, List<Integer> list, int first) {
        if (list.size() == nums.length) {result.add(new ArrayList<>(list)); return;}
        Set<Integer> visited = new HashSet<>();
        for (int i = first; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            swap(nums, i, first);
            list.add(nums[first]);
            visited.add(nums[first]);
            _permuteUnique(nums, result, list, first + 1);
            swap(nums, i, first);
            list.remove(list.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
