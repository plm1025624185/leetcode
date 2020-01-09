package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/1
 */
public class WordLadderII {

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) return Collections.emptyList();
//        List<List<String>> result = new ArrayList<>();
//        Map<String, Integer> distance = new HashMap<>();
//        Deque<String> deque = new LinkedList<>();
//        Map<String, List<String>> nodeNeighbours = new HashMap<>();
//        nodeNeighbours.put(beginWord, new ArrayList<>());
//        for(String word : wordList) nodeNeighbours.put(word, new ArrayList<>());
//        BFS(deque, beginWord, endWord, distance, nodeNeighbours);
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        DFS(beginWord, endWord, distance, nodeNeighbours, result, list);
//        return result;
//    }
//
//    /**
//     * 广度优先遍历
//     * @param deque
//     * @param beginWord
//     * @param endWord
//     * @param distance
//     * @param nodeNeighbours
//     */
//    private void BFS(Deque<String> deque, String beginWord, String endWord, Map<String, Integer> distance,
//                     Map<String, List<String>> nodeNeighbours) {
//        deque.addLast(beginWord);
//        if (nodeNeighbours.containsKey(beginWord)) nodeNeighbours.put(beginWord, new ArrayList<>());
//        distance.put(beginWord, 0);
//        while (!deque.isEmpty()) {
//            boolean isFound = false;
//            int size = deque.size();
//            while (size-- > 0) {
//                String str = deque.removeFirst();
//                getNeighbours(nodeNeighbours, str);
//                for (String neighbour : nodeNeighbours.get(str)) {
//                    if (!distance.containsKey(neighbour)) {
//                        distance.put(neighbour, distance.get(str) + 1);
//                        if (neighbour.equals(endWord)) isFound = true;
//                        else deque.addLast(neighbour);
//                    }
//                }
//                if (isFound) {
//                    break;
//                }
//            }
//        }
//    }
//
//    private void getNeighbours(Map<String, List<String>> nodeNeighbours, String current){
//        char[] chars = current.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char old = chars[i];
//            for (char c = 'a'; c <= 'z'; c++) {
//                if (c == old) continue;
//                chars[i] = c;
//                String s = new String(chars);
//                if (nodeNeighbours.containsKey(s)) {
//                    nodeNeighbours.get(current).add(s);
//                }
//            }
//            chars[i] = old;
//        }
//    }
//
//    /**
//     * 深度优先遍历
//     * @param beginWord
//     * @param endWord
//     * @param distance
//     * @param nodeNeighbours
//     * @param result
//     * @param list
//     */
//    private void DFS(String beginWord, String endWord, Map<String, Integer> distance,
//                     Map<String, List<String>> nodeNeighbours, List<List<String>> result, List<String> list){
//        if (beginWord.equals(endWord)) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        List<String> neighbours = nodeNeighbours.get(beginWord);
//        for (String neighour : neighbours) {
//            if(distance.get(neighour) == distance.get(beginWord) + 1) {
//                list.add(neighour);
//                DFS(neighour, endWord, distance, nodeNeighbours, result, list);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) return Collections.emptyList();
        Map<String, List<String>> neighbours = new HashMap<>();
        for(String s : wordList) neighbours.put(s, new ArrayList<>());
        if (!neighbours.containsKey(beginWord)) neighbours.put(beginWord, new ArrayList<>());
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);
        int step = bfs(deque, distance, wordSet, neighbours, endWord);
        if (step == -1) return Collections.emptyList();
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(result, list, neighbours, distance, beginWord, endWord);
        return result;
    }

    private int bfs(Deque<String> deque, Map<String, Integer> distance, Set<String> wordSet,
                     Map<String, List<String>> neighbours, String endWord) {
        boolean flag = false;
        int step = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String str = deque.removeFirst();
                getNeighbours(neighbours, str);
                for (String s : neighbours.get(str)) {
                    if (wordSet.contains(s) && !distance.containsKey(s)) {
                        deque.addLast(s);
                        distance.put(s, distance.get(str) + 1);
                        if (s.equals(endWord)) flag = true;
                    }
                }
            }
            step++;
            if (flag) return step;
        }
        return -1;
    }

    private void getNeighbours(Map<String, List<String>> neighbours, String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            char old = strArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (old == c) continue;
                strArray[i] = c;
                neighbours.get(str).add(new String(strArray));
            }
            strArray[i] = old;
        }
    }

    private void dfs(List<List<String>> result, List<String> list, Map<String, List<String>> neighbours,
                     Map<String, Integer> distance, String start, String end) {
        if (start.equals(end)) { result.add(new ArrayList<>(list)); return; }
        for (String str : neighbours.get(start)) {
            if (distance.containsKey(start) && distance.containsKey(str)
                    && distance.get(start) + 1 == distance.get(str)) {
                list.add(str);
                dfs(result, list, neighbours, distance, str, end);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog");
        WordLadderII w = new WordLadderII();
        w.findLadders(beginWord, endWord, wordList);
    }
}
