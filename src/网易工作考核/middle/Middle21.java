package org.example.middle;

import java.util.Scanner;

/**
 * https://www.cnblogs.com/conw/p/5896155.html
 * 连续数列
 * 分数 30
 * 作者
 * 单位
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
public class Middle21 {

    // O(n^3)
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] nums = line.split(",");
        int[] arr = new int[nums.length];
        int idx = 0;
        for(String num : nums) {
            arr[idx++] = Integer.parseInt(num);
        }

        //暴力解法,枚举所有区间
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = 0;
                //从i到j的和,累加
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                //更新最大值
                ans = Math.max(ans, sum);
            }
        }

        //输出最大值
        System.out.println(ans);
    }

    // O(n^2)
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] nums = line.split(",");
        int[] arr = new int[nums.length];
        int idx = 0;
        for(String num : nums) {
            arr[idx++] = Integer.parseInt(num);
        }

        //sums[i]表示前i个数的和
        //sums[i] = arr[i] + sums[i-1]
        int[] sums = new int[arr.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            sums[i] += arr[i] + sums[i - 1];
        }

        // i->j的和 = sum[j] - sum[i-1]
        int ans = 0;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= arr.length; j++) {
                int sum = sums[j] - sums[i - 1];
                ans = Math.max(ans, sum);
            }
        }

        //输出最大值
        System.out.println(ans);
    }

    // O(n), dp,如果已知数量以及一个一个输入,则可以省去数组,边输入边计算
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] nums = line.split(",");
        int[] arr = new int[nums.length + 1];
        int idx = 1;
        for(String num : nums) {
            arr[idx++] = Integer.parseInt(num);
        }

        //dp[i]代表以arr[i]结尾的最大连续子序和
        //dp[n] = max(0, dp[n-1]) + arr[n]
        int ans = arr[1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(0, arr[i - 1]) + arr[i];
            ans = Math.max(ans, arr[i]);
        }

        //输出动态规划数组最大值
        System.out.println(ans);
    }

    // O(n), divide and conquer
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(",");
        in.close();

        int[] nums = new int[arr.length];
        int i = 0;
        for(String num : arr) {
            nums[i++] = Integer.parseInt(num);
        }

        //分治法, 最大值 = max(左边最大值, 右边最大值, 跨中间的最大值)
        System.out.println(divideAndConquer(nums, 0, nums.length - 1));
    }

    private static int divideAndConquer(int[] arr, int left, int right) {
        //分治到一个元素为止
        if(left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;
        int leftMax = divideAndConquer(arr, left, mid);
        int rightMax = divideAndConquer(arr, mid + 1, right);
        int crossMax = crossSum(arr, left, right, mid);

        // 最大值 = max(左边最大值, 右边最大值, 跨中间的最大值)
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int crossSum(int[] arr, int left, int right, int mid) {
        if(left == right) {
            return arr[left];
        }

        //左边最大值
        int leftMax = Integer.MIN_VALUE;
        int ls = 0;
        int i = mid;
        while(i >= left) {
            ls += arr[i--];
            if(leftMax < ls) {
                leftMax = ls;
            }
        }

        //右边最大值
        int rightMax = Integer.MIN_VALUE;
        int rs = 0;
        int j = mid + 1;
        while(j <= right) {
            rs += arr[j++];
            if(rightMax < rs) {
                rightMax = rs;
            }
        }

        //左边最大值 + 右边最大值
        return leftMax + rightMax;
    }

}
