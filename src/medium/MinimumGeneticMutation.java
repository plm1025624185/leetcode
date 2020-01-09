package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/10/31
 */
public class MinimumGeneticMutation {

    /**
     * 使用广度优先搜索
     * @param start
     * @param end
     * @param bank
     * @return
     */
//    public int minMutation(String start, String end, String[] bank) {
//        if (start.equals(end)) return 0;
//        Set<String> bankSet = new HashSet<>(bank.length);
//        int level = 0; //突变次数
//        for (String b : bank) bankSet.add(b);
//        char[] chars = new char[]{'A', 'C', 'G', 'T'};
//        //设置队列存储值
//        Deque<String> deque = new LinkedList<>();
//        //访问的数组
//        Set<String> visited = new HashSet<>();
//        //设置初始值
//        deque.addLast(start);
//        visited.add(start);
//        //广度优先遍历
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            while (size-- > 0) {
//                String str = deque.removeFirst();
//                //如果与最后的基因相等，直接返回
//                if (str.equals(end)) return level;
//                char[] charArray = str.toCharArray();
//                for (int i = 0; i < charArray.length; i++) {
//                    char old = charArray[i];
//                    for (char c : chars) {
//                        charArray[i] = c;
//                        String newStr = new String(charArray);
//                        // 如果当前不是访问过的且在基因库中，进行存放
//                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
//                            deque.addLast(newStr);
//                            visited.add(newStr);
//                        }
//                    }
//                    charArray[i] = old; //还原
//                }
//            }
//            level++;
//        }
//        return -1;
//    }

//    public int minMutation(String start, String end, String[] bank) {
//        char[] array = new char[]{'A', 'C', 'G', 'T'};
//        Set<String> set = new HashSet<>();
//        Set<String> visited = new HashSet<>();
//        for (String s : bank) set.add(s);
//        if (!set.contains(end)) return -1;
//        Deque<String> deque = new LinkedList<>();
//        deque.add(start);
//        int step = 0;
//        while(!deque.isEmpty()) {
//            int size = deque.size();
//            while (size > 0) {
//                String str = deque.removeFirst();
//                char[] chars = str.toCharArray();
//                for (int i = 0; i < chars.length; i++) {
//                    char old = chars[i];
//                    for (int j = 0; j < array.length; j++) {
//                        if (old == array[j]) continue;
//                        chars[i] = array[j];
//                        String s = new String(chars);
//                        if (!visited.contains(s) && set.contains(s)) {
//                            if (s.equals(end)) return step + 1;
//                            visited.add(s);
//                            deque.add(s);
//                        }
//                    }
//                    chars[i] = old;
//                }
//                size--;
//            }
//            step++;
//        }
//        return -1;
//    }

    /**
     * 双BFS
     * @param start
     * @param end
     * @param bank
     * @return
     */
//    public int minMutation(String start, String end, String[] bank) {
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        Set<String> bankSet = new HashSet<>();
//        Set<String> visited = new HashSet<>();
//        char[] arr = new char[]{'A', 'C', 'G', 'T'};
//        for (String s : bank) bankSet.add(s);
//        int step = 0;
//        if (!bankSet.contains(end)) return -1;
//
//        //init
//        beginSet.add(start);
//        endSet.add(end);
//
//        //双bfs
//        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//            //对存储少量元素的先进行扩散
//            if (beginSet.size() > endSet.size()) {
//                Set<String> tmp = beginSet;
//                beginSet = endSet;
//                endSet = tmp;
//            }
//            //开始扩散
//            Set<String> tmpSet = new HashSet<>();
//            for (String str : beginSet) {
//                char[] chars = str.toCharArray();
//                for (int i = 0; i < chars.length; i++) {
//                    char old = chars[i];
//                    for (char c : arr) {
//                        if (old == c) continue;
//                        chars[i] = c;
//                        String n = new String(chars);
//                        if (endSet.contains(n)) return step + 1;
//                        if (!visited.contains(n) && bankSet.contains(n)) {
//                            visited.add(n);
//                            tmpSet.add(n);
//                        }
//                    }
//                    chars[i] = old;
//                }
//            }
//            step++;
//            beginSet = tmpSet;
//        }
//        return -1;
//    }

    public int minMutation(String start, String end, String[] bank) {
        char[] arr = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankset = new HashSet<>();
        for (String s : bank) bankset.add(s);
        if (!bankset.contains(end)) return -1;
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.addLast(start);
        int num = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String str = deque.removeFirst();
                char[] startarr = str.toCharArray();
                for (int i = 0; i < startarr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (startarr[i] == arr[j]) continue;
                        char tmp = startarr[i];
                        startarr[i] = arr[j];
                        String tmpstr = new String(startarr);
                        if (!visited.contains(tmpstr) && bankset.contains(tmpstr)) {
                            if (tmpstr.equals(end)) return num + 1;
                            deque.addLast(tmpstr);
                            visited.add(tmpstr);
                        }
                        startarr[i] = tmp;
                    }
                }
            }
            num++;
        }
        return -1;
    }
}
