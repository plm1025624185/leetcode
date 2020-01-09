package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/1
 */
public class WordLadder {
    /**
     * BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int level = 0;
//        Set<String> visited = new HashSet<>();
//        Deque<String> deque = new LinkedList<>();
//        Set<String> wordSet = new HashSet<>(wordList);
//        deque.addLast(beginWord);
//        visited.add(beginWord);
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            level++;
//            while (size-- > 0) {
//                String current = deque.removeFirst();
//                if (current.equals(endWord)) return level;
//                char[] curChar = current.toCharArray();
//                for (int i = 0; i < curChar.length; i++) {
//                    char old = curChar[i];
//                    for (char c = 'a'; c < 'z'; c++) {
//                        if (old != c) {
//                            curChar[i] = c;
//                            String tmp = new String(curChar);
//                            if (!visited.contains(tmp) && wordSet.contains(tmp)) {
//                                deque.addLast(tmp);
//                                visited.add(tmp);
//                                wordSet.remove(tmp);
//                            }
//                        }
//                    }
//                    curChar[i] = old;
//                }
//            }
//        }
//        return 0;
//    }

    /**
     * BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Deque<String> deque = new LinkedList<>();
//        Set<String> set = new HashSet<>(wordList);
//        deque.add(beginWord);
//        Set<String> visited = new HashSet<>();
//        int count = 1;
//        while (deque.size() != 0) {
//            int size = deque.size();
//            while (size != 0) {
//                String first = deque.removeFirst();
//                if (first.equals(endWord)) return count;
//                char[] fir = first.toCharArray();
//                for (int i = 0; i < fir.length; i++) {
//                    char tmp = fir[i];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (tmp != c) {
//                            fir[i] = c;
//                            String n = new String(fir);
//                            if (!visited.contains(n) && set.contains(n)) {
//                                deque.addLast(n);
//                                visited.add(n);
//                            }
//                        }
//                    }
//                    fir[i] = tmp;
//                }
//                size--;
//            }
//            count++;
//        }
//        return 0;
//    }

//    /**
//     * 双向BFS
//     * @param beginWord
//     * @param endWord
//     * @param wordList
//     * @return
//     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        Set<String> visited = new HashSet<>();
//        int len = 1;
//
//        if (!wordSet.contains(endWord)) return 0;
//
//        //init
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//
//        //BFS
//        while (beginSet.size() != 0 && endSet.size() != 0) {
//            //优先扩散字符较少的
//            if (beginSet.size() > endSet.size()) {
//                Set<String> tmp = beginSet;
//                beginSet = endSet;
//                endSet = tmp;
//            }
//            Set<String> tmpSet = new HashSet<>();
//            //进行扩散
//            for(String s : beginSet) {
//                char[] chars = s.toCharArray();
//                for (int i = 0; i < chars.length; i++) {
//                    char old = chars[i];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (old == c) continue;
//                        chars[i] = c;
//                        String str = new String(chars);
//                        if (endSet.contains(str)) return len + 1;
//                        if (!visited.contains(str) && wordSet.contains(str)) {
//                            visited.add(str);
//                            tmpSet.add(str);
//                        }
//                    }
//                    chars[i] = old;
//                }
//            }
//            beginSet = tmpSet;
//            len++;
//        }
//        return 0;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordList) wordSet.add(str);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        int step = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String s = deque.removeFirst();
                char[] sChar = s.toCharArray();
                for (int i = 0; i < sChar.length; i++) {
                    char old = sChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        sChar[i] = c;
                        String str = new String(sChar);
                        if (str.equals(endWord)) return step + 1;
                        if (!visited.contains(str) && wordSet.contains(str)) {
                            visited.add(str);
                            deque.addLast(str);
                        }
                    }
                    sChar[i] = old;
                }
            }
            step += 1;
        }
        return 0;
    }
}
