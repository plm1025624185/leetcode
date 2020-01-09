package easy;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class PlusOne {
//    public int[] plusOne(int[] digits) {
//        boolean isAllNine = true;
//        for (int i = digits.length - 1; i > -1; i--) {
//            if (digits[i] != 9) {
//                digits[i] = digits[i] + 1;
//                return digits;
//            }else {
//                digits[i] = 0;
//            }
//        }
//        if (isAllNine) {
//            int[] newDigits = new int[digits.length + 1];
//            newDigits[0] = 1;
//            for (int i = 1; i < newDigits.length; i++){
//                newDigits[i] = 0;
//            }
//            return newDigits;
//        }
//        return null;
//    }
//    public int[] plusOne(int[] digits) {
//        return _plusOne(digits, digits.length - 1);
//    }
//
//    private int[] _plusOne(int[] digits, int index){
//        if (index == -1) {
//            int[] result = new int[digits.length + 1];
//            result[0] = 1;
//            return result;
//        }
//        if (digits[index] + 1 == 10) {
//            digits[index] = 0;
//            return _plusOne(digits, index - 1);
//        }else {
//            digits[index] = digits[index] + 1;
//            return digits;
//        }
//    }

    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) return new int[]{1};
        int i = digits.length;
        while (--i >= 0) {
            if (digits[i] + 1 == 10) {digits[i] = 0;}
            else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else { return digits; }
    }
}
