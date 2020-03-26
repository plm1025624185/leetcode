package medium;

import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class LongestCommonSubsequence {
//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] text1Array = text1.toCharArray();
//        char[] text2Array = text2.toCharArray();
//        int m = text1Array.length;
//        int n = text2Array.length;
//        int[][] array = new int[m][n];
//        // init
//        array[0][0] = text1Array[0] == text2Array[0] ? 1 : 0;
//        for (int i = 1; i < m; i++) array[i][0] = Math.max(array[i - 1][0], text1Array[i] == text2Array[0] ? 1 : 0);
//        for (int i = 1; i < n; i++) array[0][i] = Math.max(array[0][i - 1], text2Array[i] == text1Array[0] ? 1 : 0);
//        // dp
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
//                if (text1Array[i] == text2Array[j]) array[i][j] = Math.max(array[i - 1][j - 1] + 1, array[i][j]);
//            }
//        }
//        return array[m - 1][n - 1];
//    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[][] dp = new int[arr1.length][arr2.length];
        // init
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < arr1.length; i++) { dp[i][0] = arr1[i] == arr2[0] ? 1 : dp[i - 1][0]; }
        for (int i = 1; i < arr2.length; i++) { dp[0][i] = arr1[0] == arr2[i] ? 1 : dp[0][i - 1]; }
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (arr1[i] == arr2[j]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[arr1.length - 1][arr2.length - 1];
    }
}
