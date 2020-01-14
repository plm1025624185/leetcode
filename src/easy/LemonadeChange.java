package easy;

/**
 * @author 潘磊明
 * @date 2019/11/3
 */
public class LemonadeChange {
//    public boolean lemonadeChange(int[] bills) {
//        int five = 0, ten = 0;
//        for (int i : bills) {
//            if (i == 5) five++;
//            else if (i == 10) {five--; ten++;}
//            else if (ten > 0) {ten--; five--;}
//            else five -= 3;
//            if (five < 0) return false;
//        }
//        return true;
//    }

//    public boolean lemonadeChange(int[] bills) {
//        int five = 0, ten = 0;
//        for (int i : bills) {
//            if (i == 5) five++;
//            else if(i == 10) {
//                five--;
//                ten++;
//            } else {
//                if (ten > 0){
//                    five--;
//                    ten--;
//                } else {
//                    five -= 3;
//                }
//            }
//            if (five < 0) return false;
//        }
//        return true;
//    }

    public boolean lemonadeChange(int[] bills) {
        int[] array = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) array[0]++;
            if (bills[i] == 10) {array[0]--; array[1]++;}
            if (bills[i] == 20) {
                if (array[1] > 0) {array[0]--; array[1]--;}
                else array[0] -= 3;
            }
            if (array[0] < 0 || array[1] < 0) return false;
        }
        return true;
    }
}
