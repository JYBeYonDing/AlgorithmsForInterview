package 练习;

/**
 * Created by 杨杰 on 2018/6/27 12:11.
 */
public class 第k小元素 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1, 7, 9, 8};
        System.out.println(findKthNum(arr, 0,arr.length-1,5));
    }

    private static int findKthNum(int[] arr, int start, int end,int k) {
        if (k <= 0 || k > arr.length) {
            throw new RuntimeException("k取值错误");
        }
        if (start >= end) {
            return arr[start];
        }
        int temp = (int) (Math.random() * (end-start+1))+start;
        swap(arr, temp, end);
        int p = partition(arr, start, end);
        if (k == p+1) {
            return arr[p];
        } else if (k < p+1) {
            return findKthNum(arr, start, p - 1, k);
        } else {
            return findKthNum(arr, p + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int less = start-1;//<=less的为小于pivot
        int more= end;//除了end，大于等于more的为大于pivot
        int cur=start;//less< <cur的为==pivot
        for(;cur<more;) {
            if (arr[cur] < pivot) {
                cur++;
                less++;
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        swap(arr, more, end);
        return more;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
