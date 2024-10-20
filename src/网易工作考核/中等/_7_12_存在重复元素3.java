package 网易工作考核.中等;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 *
 * 找出满足下述条件的下标对 (i, j)：
 *
 * i != j
 *
 * abs(i - j) <= indexDiff
 *
 * abs(nums[i] - nums[j]) <= valueDiff
 *
 * 如果存在，返回 1 ；否则，返回 0
 *
 *
 * 提示:
 * 2 <= nums.length <= 10^5
 *
 * -10^9 <= nums[i] <= 10^9
 *
 * 1 <= indexDiff <= nums.length
 *
 * 0 <= valueDiff <= 10^9
 *
 * 运行有时间和内存限制
 *
 * 输入格式:
 * 字符串，包括3部分：数组nums、indexDiff、valueDiff，每部分用英文逗号分隔。
 *
 * 其中，数组nums的每个元素用空格分隔。
 *
 * 输出格式:
 * 0 or 1
 */
public class _7_12_存在重复元素3 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int indexDiff = Integer.parseInt(split[1]);
        int valueDiff = Integer.parseInt(split[2]);
        String[] numsStrs = split[0].split(" ");
        int[] nums = new int[numsStrs.length];
        for (int i = 0; i < numsStrs.length; i++) {
            nums[i] = Integer.parseInt(numsStrs[i]);
        }
        TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = window.ceiling(nums[i] - valueDiff);
            if (ceiling != null && ceiling <= nums[i] + valueDiff) {
                System.out.println(1);
                return;
            }
            window.add(nums[i]);
            // windows窗口要小一个，另外一个元素是下一个窗口的i
            if (i >= indexDiff) {
                window.remove(nums[i - indexDiff ]);
            }
        }
        System.out.println(0);
    }



}
