package org.example.middle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 三数之和
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组的数量。
 *
 * 注意：答案中不可以包含重复的三元组（例如[a,b,c]与[c,b,a]为重复），如果无符合要求的三元组，则返回0。
 *
 * 提示：
 * 3 <= nums.length <= 3000
 *
 * -10^5 <= nums[i] <= 10^5
 *
 * 运行有时间、内存限制
 *
 * 输入格式:
 * 一个整数数组，每个元素其间以“空格”分隔
 *
 * 输出格式:
 * 所有符合题目要求三元组的数量，如果无符合要求的三元组，则返回0。
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * -1 0 1 2 -1 -4
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 2
 * 解释：
 *
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 *
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 *
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 *
 * 不重复的三元组总共有2组。
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 0 1 1
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 0
 */
public class Middle05 {

    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        in.close();

        String [] numsStr = line1.split(" ");
        int[] arr = new int[numsStr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(numsStr[i]);
        }

        //升序排列
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            //如果第一个数大于0，后面的数肯定大于0，不可能和为0
            if (arr[i] > 0) {
                break;
            }
            //如果当前数和前一个数相同，跳过
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == 0) {
                    cnt++;
                    //后面重复的跳过
                    while (l + 1 < arr.length && arr[l] == arr[l + 1]) {
                        l++;
                    }
                    //前面重复的跳过
                    while (r - 1 >= 0 && arr[r] == arr[r - 1]) {
                        r--;
                    }
                    //下一个不重复的位置
                    l++;
                    r--;
                } else {
                    if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
