package 网易工作考核.中等;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 * 输入格式:
 * 数组nums
 *
 * 输出格式:
 * 连续子数组的最大和
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * -2,1,-3,4,-1,2,1,-5,4
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 6
 */
public class _7_18_连续数列 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        int max = Integer.MIN_VALUE;
        int preSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (preSum < 0) {
                preSum = nums[i];
            }else{
                preSum = preSum + nums[i];
                if (preSum > max) {
                    max = preSum;
                }
            }
        }
        System.out.println(max);
    }


}
