package sort;

/**
 * 从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,7,3,5,2,6,4};
        InsertionSort is = new InsertionSort();
        is.sort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
