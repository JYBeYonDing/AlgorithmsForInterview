package org.example.simple;

import java.util.Scanner;

public class Simple22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        in.close();

        //读取
        String[] nums = num.split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        //数字数量
        int count = nums.length;

        //记录结果
        int[] counts = new int[count];

        //下标数组，保证任何时候 arr[indexes[i]] == arr[i]的原始值
        //换句话说，indexes数组最终的结果是排序后的下标，按照下标获取数据，就是有序的
        int[] indexes = new int[count];
        for (int i = 0; i < count; i++) {
            indexes[i] = i;
        }

        //记录每次归并过程中，下标的变化，最终要回填到indexes数组中
        int[] tmp = new int[count];

        //执行归并排序
        mergeSort(arr, 0, count-1, indexes, tmp, counts);

        //输出，末尾不能有空格，需要换行
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(counts[i] + " ");
        }
        System.out.println(builder.toString().trim());
    }

    private static void mergeSort(int[] arr, int s, int e, int[] indexes, int[] tmp, int[] counts) {
        if (s >= e) {
            return;
        }

        //[s, mid] 和 [mid+1, e]是有序的
        int mid = (s + e) / 2;
        mergeSort(arr, s, mid, indexes, tmp, counts);
        mergeSort(arr, mid+1, e, indexes, tmp, counts);

        int i = s;
        int j = mid + 1;

        //只需要遍历本次归并的范围即可
        int k = s;
        while(i <= mid && j <= e) {
            //当j位置的数字比i位置大，则比i位置小的数字的个数是 [mid + 1, j)的数字的个数
            //因为如何某个数字比i位置大，则一定是该数字和i位置的数字归并，而不会是j位置的数字和i位置归并，到j时i已经被归并
            if (arr[indexes[i]] <= arr[indexes[j]]) {
                int lessCnt = j - 1 - (mid + 1) + 1;
                //每次增加的数字不重合（归并是一段一段的），因此是+=
                counts[indexes[i]] += lessCnt;
                tmp[k++] = indexes[i++];
            } else {
                //j比i小，结果集不变更
                tmp[k++] = indexes[j++];
            }
        }

        //右边的都比左边当前数字小，所以加 [mid + 1, e]的个数
        while(i <= mid) {
            counts[indexes[i]] += e - (mid + 1) + 1;
            tmp[k++] = indexes[i++];
        }

        //左边的都比右边小，排序不发生变更
        while(j <= e) {
            tmp[k++] = indexes[j++];
        }

        //排序后的下标回填到下标数组
        for (int l = s; l <= e; l++) {
            indexes[l] = tmp[l];
        }
    }
}
