package org.example.simple;

import java.util.Scanner;

/**
 * 区间和的个数
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 *
 * 输入格式：
 * 整数序列，用空格分隔。
 * 整数lower代表下区间。
 * 整数upper上区间。
 *
 * 输出格式：
 * 区间和个数。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * -2 5 -1
 * -2
 * 2
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3
 *
 * 提示
 * 1 <= nums.length <= 105
 *
 * -231 <= nums[i] <= 231 - 1
 *
 * -105 <= lower <= upper <= 105
 */
public class Simple35 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int lower = Integer.parseInt(in.nextLine());
        int upper = Integer.parseInt(in.nextLine());

        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for(int i = 0; i < nums.length; i ++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int cnt = 0;
        for(int i = 0; i < nums.length; i ++) {
            int sum = 0;
            for(int j = i; j < nums.length; j ++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
