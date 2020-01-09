package sort;

/**
 * 每次找最小值，然后放到待排序数组的起始位置
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class SelectionSort {
    public void sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) min = j;
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,7,3,5,2,6,4};
        SelectionSort s = new SelectionSort();
        s.sort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
