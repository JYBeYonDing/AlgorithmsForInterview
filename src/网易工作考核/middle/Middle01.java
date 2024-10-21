package org.example.middle;

import java.util.Scanner;

/**
 * 连续的子数组和
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 *
 * 子数组元素总和为 k 的倍数。
 *
 * 如果存在，返回 1 ；否则，返回 0 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 *
 * 0 <= nums[i] <= 10^9
 *
 * 0 <= sum(nums[i]) <= 2^31 - 1
 *
 * 1 <= k <= 2^31 - 1
 *
 * 输入第一行为数组nums，第二行为整数k
 *
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 23,2,4,6,7
 * 6
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 *
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 23,2,6,4,7
 * 6
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 1
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 *
 *
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * 23,2,6,4,7
 * 13
 * 输出样例3:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Middle01 {
    public static void main(String[] args) {

        // read input
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        int k = in.nextInt();
        in.close();

        String[] strs = num.split(",");
        int[] nums = new int[strs.length];

        int i = 0;
        for(String s : strs) {
            nums[i++] = Integer.parseInt(s);
        }

        int result = getResult(nums,k);
        System.out.println(result);
    }

    private static int getResult(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            //从前往后加
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0) {
                    return 1;
                }
            }

            //从前往后减
            for(int j = i; j < nums.length - 1; j++) {
                sum -= nums[j];
                if(sum % k == 0) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
