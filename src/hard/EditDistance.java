package hard;

/**
 * @author 潘磊明
 * @date 2019/11/15
 */
public class EditDistance {
//    public int minDistance(String word1, String word2) {
//        if (word1.length() == 0) return word2.length();
//        if (word2.length() == 0) return word1.length();
//        char[] w1 = word1.toCharArray();
//        char[] w2 = word2.toCharArray();
//        int[][] dp = new int[w1.length][w2.length];
//        //init
//        if (w1[0] == w2[0]) dp[0][0] = 0;
//        else dp[0][0] = 1;
//        for (int i = 1; i < w1.length; i++) {
//            if (w1[i] == w2[0]) dp[i][0] = i;
//            else dp[i][0] = dp[i - 1][0] < i ? i : i + 1;
//        }
//        for (int j = 1; j < w2.length; j++) {
//            if (w2[j] == w1[0]) dp[0][j] = j;
//            else dp[0][j] = dp[0][j - 1] < j  ? j : j + 1;
//        }
//        for (int i = 1; i < w1.length; i++) {
//            for (int j = 1; j < w2.length; j++) {
//                if (w1[i] == w2[j]) dp[i][j] = dp[i - 1][j - 1];
//                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
//            }
//        }
//        return dp[w1.length - 1][w2.length - 1];
//    }

//    public int minDistance(String word1, String word2) {
//        if (word1.length() == 0) return word2.length();
//        if (word2.length() == 0) return word1.length();
//        char[] array1 = word1.toCharArray();
//        char[] array2 = word2.toCharArray();
//        int len1 = word1.length();
//        int len2 = word2.length();
//        int[][] dp = new int[len1][len2];
//        //init
//        boolean flag = false;
//        for (int i = 0; i < len1; i++) {
//            if (flag) {dp[i][0] = i; continue;}
//            if (array1[i] == array2[0]) { dp[i][0] = i; flag = true;}
//            else dp[i][0] = i + 1;
//        }
//        flag = false;
//        for (int i = 0; i < len2; i++) {
//            if (flag) {dp[0][i] = i; continue;}
//            if (array1[0] == array2[i]) { dp[0][i] = i; flag = true;}
//            else dp[0][i] = i + 1;
//        }
//        for (int i = 1; i < len1; i++) {
//            for (int j = 1; j < len2; j++) {
//                if (array1[i] == array2[j]) dp[i][j] = dp[i - 1][j - 1];
//                else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//                }
//            }
//        }
//        return dp[len1 - 1][len2 - 1];
//    }

    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        if (arr1.length == 0 && arr2.length == 0) return 0;
        if (arr1.length == 0) return arr2.length;
        if (arr2.length == 0) return arr1.length;
        int[][] dp = new int[arr1.length][arr2.length];
        // init
        dp[0][0] = arr1[0] == arr2[0] ? 0 : 1;
        for (int i = 1; i < arr1.length; i++) {
            dp[i][0] = arr1[i] == arr2[0] ? i : dp[i - 1][0] + 1;
        }
        for (int i = 1; i < arr2.length; i++) {
            dp[0][i] = arr2[i] == arr1[0] ? i : dp[0][i - 1] + 1;
        }
        // dp
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[arr1.length - 1][arr2.length - 1];
    }
}
