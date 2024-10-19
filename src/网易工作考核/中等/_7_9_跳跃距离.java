package 网易工作考核.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 给定一个非负整数数组nums，最初位于数组的第一个位置；数组中的每个元素表示你在该位置可以跳跃的最大长度。
 *
 * 请确定是否可以到达最后一个位置。
 *
 *
 * 输入格式:
 * 每个测试用例一行，以“,”分隔，代表nums数组
 *
 * 输出格式:
 * 请确定是否可以到达最后一个位置。如果能，返回true，否则返回false
 *
 *
 * 输出样例1：
 * 在这里给出一组输入。例如：
 *
 * 2,3,1,1,4
 * 输出样例1：
 * 在这里给出相应的输出。例如：
 *
 * true
 */
public class _7_9_跳跃距离 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i+nums[i]);
            if (max <= i) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
