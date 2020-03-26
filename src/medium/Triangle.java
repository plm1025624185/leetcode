package medium;

import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class Triangle {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int[] paths = new int[triangle.size()];
//        if (paths.length == 1) return triangle.get(0).get(0);
//        //init
//        List<Integer> list = triangle.get(triangle.size() - 1);
//        for (int i = 0; i < list.size(); i++) paths[i] = list.get(i);
//        for (int i = paths.length - 2; i >= 0; i--) {
//            List<Integer> array = triangle.get(i);
//            for (int j = 0; j < array.size(); j++) {
//                paths[j] = Math.min(paths[j], paths[j + 1]) + triangle.get(i).get(j);
//            }
//        }
//        return paths[0];
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        // init
        for (int i = 0; i < dp.length; i++) dp[i] = triangle.get(triangle.size() - 1).get(i);
        // dp
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
