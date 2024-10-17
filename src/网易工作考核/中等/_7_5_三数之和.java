package 网易工作考核.中等;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组的数量。
 * <p>
 * 注意：答案中不可以包含重复的三元组（例如[a,b,c]与[c,b,a]为重复），如果无符合要求的三元组，则返回0。
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * <p>
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 运行有时间、内存限制
 * <p>
 * 输入格式:
 * 一个整数数组，每个元素其间以“空格”分隔
 * <p>
 * 输出格式:
 * 所有符合题目要求三元组的数量，如果无符合要求的三元组，则返回0。
 * <p>
 * 输入样例1:
 * 在这里给出一组输入。例如：
 * <p>
 * -1 0 1 2 -1 -4
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 * <p>
 * 2
 */
public class _7_5_三数之和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                break;
            }
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmp = a + nums[l] + nums[r];
                if (tmp < 0) {
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                } else if (tmp > 0) {
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else {
                    res++;
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }
        }
        System.out.println(res);

    }


}
