package hard;

import test.Solution;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2020/3/3
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int num = nums.length;
        int[] sub = new int[num + 1];
        int[][] dp = new int[num + 1][m + 1];
        //初始化
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < num; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[num][m];
    }

    public String replaceSpaces(String S, int length) {
        char[] array = S.toCharArray();
        //预处理
        int head = 0, tail = array.length - 1, count = S.length() - length;
        while (count > 0) {
            if (array[tail] == ' ') {
                tail--;
                count--;
            } else if (array[head] == ' ') {
                head++;
                count--;
            }
        }
        StringBuilder sb =new StringBuilder();
        for (int i = head; i < tail + 1; i++) {
            if (array[i] == ' ') sb.append("%20");
            else sb.append(array[i]);
        }
        return sb.toString();
    }

    public boolean canPermutePalindrome(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        int count = 1;
        for (int i = 0; i < array.length;) {
            if (count < 0) return false;
            if (i + 1 == array.length || array[i] != array[i + 1]) {
                i++;
                count--;
            } else {
                i += 2;
            }
        }
        return count < 0 ? false : true;
    }

    public boolean oneEditAway(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        if (first.equals(second)) return true;
        if (firstArray.length == 0 && secondArray.length == 1 || firstArray.length == 1 && secondArray.length == 0) return true;
        if (Math.abs(firstArray.length - secondArray.length) > 1) return false;
        int firhead = 0;
        int sechead = 0;
        int firtail = firstArray.length - 1;
        int sectail = secondArray.length - 1;
        while (firhead < firtail && sechead < sectail && firstArray[firhead] == secondArray[sechead]) {
            firhead++;
            sechead++;
        }
        while(firhead < firtail && sechead < sectail && firstArray[firtail] == secondArray[sectail]) {
            firtail--;
            sectail--;
        }
        if (firhead == firtail && sechead == sectail) return true;
        if (firhead == firtail && (firstArray[firhead] == secondArray[sechead] || firstArray[firhead] == secondArray[sectail])) return true;
        if (sechead == sectail && (firstArray[firhead] == secondArray[sechead] || firstArray[firtail] == secondArray[sectail])) return true;
        return false;
    }

    public int longestPalindrome(String s) {
        int total = 0;
        Set<Character> set = new LinkedHashSet<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                total += 2;
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        if (set.size() > 0) total++;
        return total;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) return slow;
        else return slow.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        int dp_0 = nums[0]; // 代表预约
        int dp_1 = 0; // 代表不预约
        for (int i = 1; i < nums.length; i++) {
            int tmp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + nums[i]);
            dp_1 = Math.max(dp_1, tmp);
        }
        return Math.max(dp_0, dp_1);
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0 && s2.length() == 0) return true;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int tmp = -1;
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[j]) {
                j++;
                if (tmp == -1) tmp = i;
            } else {
                j = 0;
                tmp = -1;
            }
        }
        if (tmp == - 1) return false;
        for (int i = 0; i < tmp; i++) {
            if (arr1[i] != arr2[j]) return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum s = new SplitArrayLargestSum();
        s.oneEditAway("teacher",
                "teacha");
    }
}
