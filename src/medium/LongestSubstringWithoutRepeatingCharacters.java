package medium;

/**
 * 给定一个字符串，找到最长的不重复的子串
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int solutionOne(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int i = 0;
        int j = 1;
        int pos = -1;
        int max = 0;
        for(; j < s.length(); j++){
            pos = s.substring(i,j).indexOf(s.substring(j, j + 1));
            max = max > j - i ? max : j - i;
            if(pos != -1){
                //如果字符在子符串中，则i移到重复位置+1的地方
                i =  i + pos + 1;
            }
            //判断最大长度是否大于剩下字串长度，是的话就直接返回
            if(max > s.length() - i ){
                return max;
            }
        }
        return max > j - i ? max : j - i;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ss = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ss.solutionOne("abcabcbb"));
    }
}
