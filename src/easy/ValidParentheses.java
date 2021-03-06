package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class ValidParentheses {
    /**
     * 使用栈
     * @param s
     * @return
     */
//    public boolean isValid(String s) {
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            String tmp = s.substring(i, i + 1);
//            if (stack.empty()) {
//                stack.push(tmp);
//            }else {
//               if (isValid(stack.peek(), tmp)){
//                   stack.pop();
//               }else {
//                   stack.push(tmp);
//               }
//            }
//        }
//        return stack.empty();
//    }
//
//    boolean isValid(String left, String right){
//        if("(".equals(left) && ")".equals(right)){
//            return true;
//        }else if ("[".equals(left) && "]".equals(right)) {
//            return true;
//        }else if ("{".equals(left) && "}".equals(right)) {
//            return true;
//        }
//        return false;
//    }

//    public boolean isValid(String s) {
//        if (s == "") return true;
//        char[] array = s.toCharArray();
//        Deque<Character> deque = new LinkedList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (deque.isEmpty()) deque.addFirst(array[i]);
//            else if (canRemove(deque.getFirst(), array[i])) deque.removeFirst();
//            else deque.addFirst(array[i]);
//        }
//        return deque.isEmpty();
//    }
//
//    private boolean canRemove(char left, char right){
//        if(left == '(' && right == ')') return true;
//        else if (left == '[' && right == ']') return true;
//        else if (left == '{' && right == '}') return true;
//        else return false;
//    }

//    public boolean isValid(String s) {
//        Deque<Character> deque = new LinkedList();
//        char[] chars = s.toCharArray();
//        if (chars.length == 0) return true;
//        for (int i = 0; i < chars.length; i++) {
//            if (deque.isEmpty()) deque.addFirst(chars[i]);
//            else {
//                char first = deque.peekFirst();
//                if (chars[i] - first == 1 || chars[i] - first == 2) deque.removeFirst();
//                else deque.addFirst(chars[i]);
//            }
//        }
//        return deque.isEmpty();
//    }

    public boolean isPerfectSquare(int num) {
        long cur = num;
        while (cur * cur > num) {
            cur = (cur + num / cur) / 2;
        }
        return cur * cur == num;
    }
}
