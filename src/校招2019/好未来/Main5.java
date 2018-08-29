package 校招2019.好未来;

import java.util.Scanner;

/**
 * Created by James on 2018/8/28 22:12.
 *
 * 5 1 3 4 9 7 6 8
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");

        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {

            nums[i] = Integer.parseInt(strings[i]);
        }

        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = getMaxBefore(nums,dp, i) + nums[i];
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    private static int getMaxBefore(int[] nums, int[] dp, int index) {
        int res = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] <= nums[index]) {
                res = Math.max(res,dp[i]);
            }
        }
        return res;

    }


}
