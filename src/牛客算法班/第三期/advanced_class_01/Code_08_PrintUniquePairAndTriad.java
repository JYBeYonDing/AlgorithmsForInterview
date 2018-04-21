package 牛客算法班.第三期.advanced_class_01;

/**
 * Created by 杨杰 on 2018/4/20 17:57.
 * 数组中和为特定值的数据对。
 *
 */
public class Code_08_PrintUniquePairAndTriad {
    public static void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                if (left == 0 || arr[left - 1] != arr[left]) {
                    System.out.println(arr[left]+","+arr[right]);
                }
                left++;
                right--;
            }
        }
    }


    /**
     * 如果要求三个数的之和为特定值的数据对
     * 可以从头到尾依次取一个数，然后从后面的数中按取两个数之和为特定数的方法取出后面两个数的数据对
     */

}
