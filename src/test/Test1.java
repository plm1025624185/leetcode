package test;

import medium.FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 潘磊明
 * @date 2020/1/5
 */
public class Test1 {
    public String freqAlphabets(String s) {
        char[] sarr = s.toCharArray();
        String tmp = "";
        for (int i = sarr.length - 1; i >= 0; i--) {
            if (sarr[i] != '#') {
                tmp = ((char)(96 + Integer.parseInt(s.substring(i, i + 1)))) + tmp;
            } else {
                tmp = ((char)(96 + Integer.parseInt(s.substring(i - 2, i)))) + tmp;
                i -= 2;
            }
        }
        return tmp;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int left = queries[0][0];
        int right = queries[0][1];
        for (int i = 1; i < queries.length; i++) {
            left = Math.min(queries[i][0], left);
            right = Math.max(queries[i][1], right);
        }
        int max = arr[left];
        for (int i = left + 1; i < right + 1; i++) {
            max = max ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int p = queries[i][0];
            int q = queries[i][1];
            int tmp = 0;
            if (q - p > (right - left / 2)) {
                tmp = max;
                for (int j = left; j <= p; j++) {
                    tmp = tmp ^ arr[j];
                }
                for (int j = right; j >= q; j--) {
                    tmp = tmp ^ arr[j];
                }
            } else {
                tmp = arr[p];
                for (int j = p + 1; j <= q; j++) {
                    tmp = tmp ^ arr[j];
                }
            }
            result[i] = tmp;
        }
        return result;
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            for (int j = 0; j < friends[i].length; j++) {
                map.get(i).add(j);
            }
        }
        Set<Integer> fset = new HashSet<>();
        fset.add(id);
        Set<Integer> set = getFriends(map, fset, level);
        set.remove(id);
        Map<String, Integer> m = getVideos(set, watchedVideos);
        List<String> s = new ArrayList<>();
        for(Map.Entry<String, Integer> val : m.entrySet()) {
            s.add(val.getValue() + "-" + val.getKey());
        }
        Collections.sort(s);
        return s.stream().map( e -> {
            int ind = e.indexOf("-");
            return e.substring(ind + 1);
        }).collect(Collectors.toList());
    }

    private Set<Integer> getFriends(Map<Integer, List<Integer>> map, Set<Integer> fset, int level) {
        if (level == 0) return fset;
        Set<Integer> set = new HashSet<>();
        fset.stream().forEach(e -> {
            set.addAll(map.get(e));
        });
        return getFriends(map, set, level - 1);
    }

    private Map<String, Integer> getVideos(Set<Integer> set, List<List<String>> watchedVideos) {
        Map<String, Integer> map = new HashMap<>();
        set.stream().forEach(e -> {
            for(String video : watchedVideos.get(e)) {
                if (map.containsKey(video)) map .put(video, map.get(video) + 1);
                else map.put(video, 1);
            }
        });
        return map;
    }

    public static void main(String[] args) {
        System.out.print(7 ^ 4);
    }
}
