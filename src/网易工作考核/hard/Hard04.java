package org.example.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 最长递增子序列
分数 60
作者 
单位 
给你一个整数数组nums，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

输入格式:
1 <= nums.length <= 2000
-10000 <= nums[i] <= 10000

输出格式:
最长严格递增子序列的长度


输入样例:
在这里给出一组输入。例如：

10 9 2 5 3 7 101 18
输出样例:
在这里给出相应的输出。例如：

4

 */
public class Hard04 {
    public static void main(String[] args) {
        // read
        Scanner in = new Scanner(System.in);
        String vals = in.nextLine();
        in.close();

        String[] sarr = vals.split(" ");
        int[] arr1 = new int[sarr.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.valueOf(sarr[i]);
            set.add(Integer.valueOf(sarr[i]));
        }

        List<Integer> list = new ArrayList<>(set);
        //原数组和递增的数组做最长公共子序列，递增数组需要无重复元素
        Collections.sort(list);
        int[] arr2 = list.stream().mapToInt(Integer::valueOf).toArray();

        //第一行和第一列为0，代表对方为空情况下，没有公共序列
        int[][] seq = new int[arr1.length + 1][arr2.length + 1];

        int max = 0;
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                int x = arr1[i - 1];
                int y = arr2[j - 1];
                if (x == y) {
                    seq[i][j] = seq[i-1][j-1] + 1;
                } else {
                    seq[i][j] = Math.max(seq[i-1][j], seq[i][j-1]);
                }

                if (seq[i][j] > max) {
                    max = seq[i][j];
                }
            }
        }
        // print(seq);
        // System.out.println();
        System.out.println(max);
    }
    private static void print(int[][] network) {
        System.out.println();
        for (int i = 0; i < network.length; i++) {
            System.out.print("[");
            for (int j = 0; j < network.length; j++) {
                System.out.print(" " + network[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
