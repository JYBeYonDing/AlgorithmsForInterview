package 网易工作考核.简单;

import java.util.Arrays;
import java.util.Scanner;


public class _7_16_向数组中追加K个整数 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length + 2];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        nums[split.length + 1] = 0;
        nums[split.length] = Integer.MAX_VALUE;
        int k = in.nextInt();
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i + 1 < nums.length && k != 0; i++) {
            int count = nums[i + 1] - nums[i] - 1;
            if (count <= 0) {
                continue;
            }
            if (count <= k) {
                res += numSum(nums[i] + 1, nums[i + 1] - 1);
                k -= count;
            } else {
                res += numSum(nums[i] + 1, nums[i] + k);
                k = 0;
            }
        }

        System.out.println(res);
    }

    private static long numSum(int num1, int num2) {
        return (long) (num1 + num2) * (long) (num2 - num1 + 1) / 2;
    }


}
