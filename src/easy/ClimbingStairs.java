package easy;

/**
 * @author 潘磊明
 * @date 2019/10/18
 */
public class ClimbingStairs {
    /**
     * 使用递归思想解决问题
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        if (n < 3) {
//            return n;
//        } else {
//            //设置两个变量记录缓存值
//            int prev = 1;
//            int cur = 2;
//            for(int i = 3; i < n; i++) {
//                int tmp = prev + cur;
//                prev = cur;
//                cur = tmp;
//            }
//            return prev + cur;
//        }
//    }

//    public int climbStairs(int n){
//        if (n < 3) return n;
//        int x = 1, y = 2;
//        for (int i = 3; i <= n; i++) {
//            int tmp = x + y;
//            x = y;
//            y = tmp;
//        }
//        return y;
//    }

    /**
     * 递归解决
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        int[] cache = new int[n + 1];
//        _reserval(cache, n);
//        return cache[n];
//    }
//
//    private void _reserval(int[] cache, int n){
//        if (n == 1 || n == 2) {cache[n] = n; return;}
//        if (cache[n - 1] == 0) _reserval(cache, n - 1);
//        if (cache[n - 2] == 0) _reserval(cache, n - 2);
//        cache[n] = cache[n - 1] + cache[n - 2];
//    }

    /**
     * 动态规划
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        if (n < 3) return n;
//        int dp_n_2 = 1;
//        int dp_n_1 = 2;
//        for (int i = 2; i < n; i++) {
//            int tmp = dp_n_2 + dp_n_1;
//            dp_n_2 = dp_n_1;
//            dp_n_1 = tmp;
//        }
//        return dp_n_1;
//    }

    /**
     * 递归
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        int[] array = new int[n + 1];
//        _recursive(n, array);
//        return array[n];
//    }
//
//    private void _recursive(int n, int[] array) {
//        if (n == 1 || n == 2) {array[n] = n; return;}
//        if (array[n - 1] == 0) _recursive(n - 1, array);
//        if (array[n - 2] == 0) _recursive(n - 2, array);
//        array[n] = array[n - 1] + array[n - 2];
//    }

    public int climbStairs(int n) {
        if (n < 3) return n;
        int dp_1 = 1;
        int dp_2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = dp_1;
            dp_1 = dp_2;
            dp_2 = dp_1 + tmp;
        }
        return dp_2;
    }
}
