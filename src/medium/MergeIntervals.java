package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/12/6
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        List<Integer> llist = new ArrayList<>();
        List<Integer> rlist = new ArrayList<>();
        int l = 0, r = 0;
        for (;l < left.length;) {
            llist.add(left[l]);
            l++;
            while (l < left.length && right[r] >= left[l]) {
                r++;l++;
            }
            rlist.add(right[r]);
            r++;
        }
        int[][] array = new int[llist.size()][2];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[] {
                    llist.get(i), rlist.get(i)
            };
        }
        return array;
    }
}
