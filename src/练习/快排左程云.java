package 练习;

import static 练习.荷兰国旗.swap;

/**
 * Created by 杨杰 on 2018/6/8 21:19.
 */
public class 快排左程云 {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 5, 5, 6, 4, 3};
        quickSortRec(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    private static void quickSortRec(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int[] p = partition(arr, start, end);
        quickSortRec(arr, start, p[0]-1);
        quickSortRec(arr,p[1]+1,end);
    }

    private static int[] partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int less = start - 1;
        int more = end;
        while (start < more) {
            if (arr[start] < pivot) {
                less++;
                swap(arr, less, start);
                start++;
            } else if (arr[start] == pivot) {
                start++;
            } else {
                swap(arr, start, --more);
            }
        }
        swap(arr, more, end);
        return new int[]{less + 1, more};
    }
}
