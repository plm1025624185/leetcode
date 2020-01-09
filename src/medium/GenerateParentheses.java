package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class GenerateParentheses {

//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        _generate(0, 0, n, "", list);
//        return list;
//    }
//
//    private void _generate(int left, int right, int n, String s, List<String> list){
//        if (left == n && right == n) {
//            list.add(s);
//        }
//        if (left < n)
//                _generate(left + 1, right, n, s + "(", list);
//        if (right < left && right < n)
//                _generate(left, right + 1, n, s + ")", list);
//    }

//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        _generate(list, "(", n - 1, n);
//        return list;
//    }
//
//    /**
//     * 先用递归解决
//     * @param list
//     * @param tmp
//     * @param left
//     * @param right
//     */
//    private void _generate(List<String> list, String tmp, int left, int right){
//        if (left == 0 && right == 1) {
//            list.add(tmp + ")");
//            return;
//        }
//        if (left != 0 ) _generate(list, tmp + "(", left - 1, right);
//        if (right > left && right != 1) _generate(list, tmp + ")", left, right - 1);
//    }

//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        _generate(result, n - 1, n, "(");
//        return result;
//    }
//
//    private void _generate(List<String> list, int left, int right, String str) {
//        if (left == 0 && right == 0) {list.add(str);return;}
//        if (left != 0 && left <= right) _generate(list, left - 1, right, str + "(");
//        if (right != 0 && right > left) _generate(list, left, right - 1, str + ")");
//    }

//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        _generate(result, "(",n - 1, n);
//        return result;
//    }
//
//    /**
//     * 生成括号
//     * @param result
//     * @param tmp
//     * @param left
//     * @param right
//     */
//    private void _generate(List<String> result, String tmp, int left, int right) {
//        if (left == 0 && right == 0) {result.add(tmp); return;}
//        if (left >=0 && left <= right) {
//            _generate(result, tmp + "(", left - 1, right);
//            if (left != right)
//                _generate(result, tmp + ")", left, right - 1);
//        }
//    }

//    public List<String> generateParenthesis(int n){
//        if (n == 0) return Collections.emptyList();
//        if (n == 1) return Arrays.asList("()");
//        List<List<String>> dp = new ArrayList<>();
//        //init
//        dp.add(Arrays.asList(""));
//        dp.add(Arrays.asList("()"));
//        for (int i = 2; i < n + 1; i++) {
//            List<String> tmp = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                List<String> plist = dp.get(j);
//                List<String> qlist = dp.get(i - 1 - j);
//                for (String p : plist) {
//                    for (String q : qlist) {
//                        tmp.add("(" + p + ")" + q);
//                    }
//                }
//            }
//            dp.add(tmp);
//        }
//        return dp.get(n);
//    }

    /**
     * 使用迭代
     * @param n
     * @return
     */
//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        generateParenthesis(result, "(", n - 1, n);
//        return result;
//    }
//
//    private void generateParenthesis(List<String> list, String str, int left, int right) {
//        if (left == 0 && right == 0) {list.add(str); return;}
//        if (left > 0 && left <= right)  generateParenthesis(list,str + "(", left - 1, right);
//        if (right > 0) generateParenthesis(list, str + ")", left, right - 1);
//    }

    /**
     * 使用动态规划
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Arrays.asList("()");
        // init
        dp.add(Arrays.asList(""));
        dp.add(Arrays.asList("()"));
        for (int i = 2; i < n + 1; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> plist = dp.get(j);
                List<String> qlist = dp.get(i - 1 - j);
                for (String p : plist) {
                    for (String q : qlist) {
                        tmp.add("(" + p + ")" + q);
                    }
                }
            }
            dp.add(tmp);
        }
        return dp.get(n);
    }
}
