package hard;

/**
 * @author 潘磊明
 * @date 2019/9/6
 *
 * 有两个长度分别为m和n已经排好序的数组；
 * 找出两个排好序数组的中间的值。
 * 总运行时间复杂度应为O（log（m + n））
 * 可以假设nums1和nums2都不全为空
 */
public class MedianOfTwoSortedArrays {

    /**
     * 改时间复杂度不是要求的O(log(m+n))应该是O(m + n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] tmpArray;
        if (m == 0){
            tmpArray = nums2;
        }else if(n == 0){
            tmpArray = nums1;
        }else {
            tmpArray = new int[m + n];
            int x = 0;
            int y = 0;
            for (int i = 0; i < tmpArray.length; i++) {
                if(x <m && y<n){
                    if(nums1[x] > nums2[y]){
                        tmpArray[i] = nums2[y];
                        y++;
                    }else{
                        tmpArray[i] = nums1[x];
                        x++;
                    }
                }else if(x>m - 1){
                    tmpArray[i] =  nums2[y];
                    y++;
                }else{
                    tmpArray[i] = nums1[x];
                    x++;
                }
            }
        }
        int mid = (m + n) / 2;
        if((m+n) % 2 == 0){
            return (((double)tmpArray[mid] + (double)tmpArray[mid - 1])/2);
        }else{
            return (double)tmpArray[mid];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays array = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        array.findMedianSortedArrays(nums1, nums2);
    }
}
