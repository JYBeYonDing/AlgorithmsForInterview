package 练习;

import static 练习.荷兰国旗.swap;

/**
 * Created by 杨杰 on 2018/6/8 21:34.
 */
public class 堆排序练习 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 7, 5, 4, 7, 2};
        for(int i=1;i<arr.length;i++) {// 建大根堆
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            swap(arr, 0, --size);
            heapfy(arr, size);
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    private static void heapfy(int[] arr, int size) {
        int i = 0;
        while(2*i+1<size) {
            int max = (2 * i + 2) < size ? ((arr[2 * i + 1] < arr[2 * i + 2]) ? 2 * i + 2 : 2 * i + 1) : 2 * i + 1;
            max = (arr[max] < arr[i]) ? i : max;
            if (max == i) {
                break;
            } else {
                swap(arr, i, max);
                i = max;
            }
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[i / 2]) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }
}
