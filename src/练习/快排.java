package 练习;

/**
 * Created by 杨杰 on 2018/7/5 17:17.
 */
public class 快排 {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 5, 5, 6, 4, 3};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickRec(arr, 0, arr.length - 1);
    }

    private static void quickRec(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int[] p = partition(arr, start, end);
        quickRec(arr, start, p[0] - 1);
        quickRec(arr, p[1] + 1, end);
    }

    private static int[] partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int less = start - 1;
        int more = end;
        while (start < more) {
            if (arr[start] < pivot) {
                less++;
                swap(arr,less,start);
                start++;
            } else if (arr[start] > pivot) {
                more--;
                swap(arr, start, more);
            } else {
                start++;
            }
        }
        swap(arr, more, end);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
