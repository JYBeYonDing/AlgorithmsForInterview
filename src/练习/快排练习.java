package 练习;

import static 练习.荷兰国旗.swap;

/**
 * Created by 杨杰 on 2018/6/8 20:40.
 */
public class 快排练习 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 2, 3, 41, 2, 2};
        quickSortRec(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    private static void quickSortRec(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(arr, start, end);
        quickSortRec(arr, start, p - 1);
        quickSortRec(arr,p+1,end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int less = start - 1;
        int more = end;
        while (less < more) {
            while (less<more && arr[++less] <= pivot) {
            }
            while (more > less && arr[--more] > pivot) {
            }
            swap(arr, less, more);
        }
        swap(arr, less, end);
        return less;
    }
}
