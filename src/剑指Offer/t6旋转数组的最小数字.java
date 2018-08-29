package 剑指Offer;

/**
 * Created by 杨杰 on 2018/7/3 23:16.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class t6旋转数组的最小数字 {
    // 暴力遍历求解
    public int minNumberInRotateArray(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length <= 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


    // 二分查找方法
    public static int minNumberInRotateArray2(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length <= 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int min = Math.min(array[start], array[end]);//数组两端的最小值
        while (start < end) {// 找出数组中间的最小值
            int mid = start + ((end - start) >> 1);
            if (array[mid] > array[start]) {
                start = mid;
            } else if (array[mid] < array[start]) {
                end = mid;
            } else {
                start = start + 1;// 如果相等的话，只能采用顺序查找的方式，例如 1,1,0,1,1,1
            }
        }
        return Math.min(min, array[end]);
    }

    public static void main(String[] args) {
        int[] arr = {6501,
                6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        System.out.println(minNumberInRotateArray2(arr));

    }
}