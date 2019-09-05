package simple;

import java.util.Stack;

/**
 * 给定一定32位的有符号位的整形，将它进行反转
 *
 * 例子1：
 * in:123
 * out:321
 *
 * 例子2：
 * in:-123
 * out:-321
 *
 * 例子3：
 * in:120
 * out:21
 */
public class ReverseInteger {
    public int solutionOne(int x){
        //获取长度
        int length = ("" + Math.abs(x)).length() - 1;
        int tmp = 0;
        int sum = 0;
        while(x != 0){
            //先判断最高位有没有大于或小于int的边界
            tmp = x % 10;

            if(sum + tmp * Math.pow(10, length) > Integer.MAX_VALUE ||
                    sum + tmp * Math.pow(10, length) < Integer.MIN_VALUE){
                return 0;
            }

            sum += tmp * Math.pow(10, length);
            x = x / 10;
            length--;
        }
        return sum;
    }

    public int solutionTwo(int x){
        long re = 0;
        while(x != 0){
            re = re * 10 + x % 10;
            x = x / 10;
        }
        if(re > Integer.MAX_VALUE || re < Integer.MIN_VALUE){
            return 0;
        }
        return (int) re;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.solutionOne(
                1563847412));
    }
}
