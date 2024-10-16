package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * <p>
 * 输入格式：
 * 整数序列，用空格分隔。
 * 整数lower代表下区间。
 * 整数upper上区间。
 * <p>
 * 输出格式：
 * 区间和个数。
 * <p>
 * 输入样例:
 * 在这里给出一组输入。例如：
 * <p>
 * -2 5 -1
 * -2
 * 2
 * 输出样例:
 * 在这里给出相应的输出。例如：
 * <p>
 * 3
 */
public class _7_27_区间和的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        int[] sums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
        int lower = in.nextInt();
        int upper = in.nextInt();

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tmp;
                if (i == 0) {
                    tmp = sums[j];
                } else {
                    tmp = sums[j] - sums[i - 1];
                }
                if (tmp >= lower && tmp <= upper) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }


}
