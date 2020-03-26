package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2020/3/17
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] visited = new int[26];
        char[] charArray = chars.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            visited[charArray[i] - 'a'] += 1;
        }
        int count = 0;
        retry:
        for(String str : words) {
            int[] copy = new int[26];
            System.arraycopy(visited, 0, copy, 0, 26);
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (copy[arr[i] - 'a'] == 0) continue retry;
                copy[arr[i] - 'a'] -= 1;
            }
            count += arr.length;
        }
        return count;
    }
}
