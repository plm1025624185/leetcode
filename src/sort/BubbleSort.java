package sort;

/**
 * 嵌套循环，每次查看相邻的元素，如果逆序则交换
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,7,3,5,2,6,4};
        BubbleSort is = new BubbleSort();
        is.sort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
