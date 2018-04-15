package 牛客算法班.第三期.basic_class_01;

import java.util.Arrays;

/**
 * Created by 杨杰 on 2018/4/15 11:36.
 * 对数器的概念和使用
 0， 有一个你想要测的方法a，
 1， 实现一个绝对正确但是复杂度不好的方法b，
 2， 实现一个随机样本产生器
 3， 实现比对的方法 isEqual
 4， 把方法a和方法b比对很多次来验证方法a是否正确。
 5， 如果有一个样本使得比对出错， 打印样本分析是哪个方法出错
 6， 当样本数量很多时比对测试依然正确， 可以确定方法a已经正确。
 */
public class 数组题目对数器 {

    /**
     * 设计一个绝对正确的方法
     * 可以是时间复杂度很高的算法，容易写出来，保证正确就行
     * 如果写的不正确，设计样本长度较小的样本，打印出出错的情况，肉眼观察哪里出错了，进行调整
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 产生随机样本的产生器
     * 随机数组产生规则根据实际情况自己修改
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 产生一个数组长度在[0,maxSize]内的随机数组
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        // 给数组中的每个值产生一个随机数，值在[-maxValue,+maxValue]之间
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 用于复制数组
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个结果是否相等的方法
     * 根据实际题目进行调整
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印函数
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 进行大样本测试
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            /**
             * 需要测试的方法
             */
            //bubbleSort(arr1);
            /**
             * 绝对正确的方法
             */
            comparator(arr2);
            /**
             * 将两个结果进行比较
             */
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "错误!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        /**
         * 需要测试的方法
         */
//        bubbleSort(arr);
        printArray(arr);
    }

}
