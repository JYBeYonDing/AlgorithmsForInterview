package 牛客网.算法广告课.局部最小值;

/**
 * Created by 杨杰 on 2018/4/10 21:34.
 * 完成 21:52 不好
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        int res = findMinIdx(arr);
        System.out.println(res);
    }

    private static int findMinIdx(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] < arr[1] ? 0 : 1;
        }
        int left = 0;
        int right = arr.length;
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[right - 1] < arr[right - 2]) {
            return right - 1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                left = mid+1;
                continue;
            }
            if (arr[mid] > arr[mid - 1]) {
                right = mid-1;
                continue;
            }
        }
        return left;

    }
}
