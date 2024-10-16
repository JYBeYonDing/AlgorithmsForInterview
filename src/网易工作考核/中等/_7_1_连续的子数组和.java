package 网易工作考核.中等;

import java.util.Scanner;


/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * <p>
 * 子数组元素总和为 k 的倍数。
 * <p>
 * 如果存在，返回 1 ；否则，返回 0 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * <p>
 * 0 <= nums[i] <= 10^9
 * <p>
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * <p>
 * 1 <= k <= 2^31 - 1
 * <p>
 * 输入第一行为数组nums，第二行为整数k
 * <p>
 * 在这里给出一组输入。例如：
 * <p>
 * 23,2,4,6,7
 * 6
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 * <p>
 * 1
 */
public class _7_1_连续的子数组和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int k = in.nextInt();
        int[] nums = new int[split.length];
        long[] sums = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long tmp;
                if (i == 0) {
                    tmp = sums[j];
                }else{
                    tmp = sums[j] - sums[i - 1];
                }
                if (tmp % k == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }


}
