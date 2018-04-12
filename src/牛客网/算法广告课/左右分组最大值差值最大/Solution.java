package 牛客网.算法广告课.左右分组最大值差值最大;

/**
 * Created by 杨杰 on 2018/4/10 21:27.
 * 完成21:32
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 4, 1, 2};
        int res = getResult(arr);
        System.out.println(res);
    }


    private static int getResult(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int max = arr[0];
        for(int i = 1 ; i<arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min = arr[0] < arr[arr.length - 1] ? arr[0] : arr[arr.length - 1];
        return max - min;
    }
}
