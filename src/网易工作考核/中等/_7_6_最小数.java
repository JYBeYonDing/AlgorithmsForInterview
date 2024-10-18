package 网易工作考核.中等;

import com.alibaba.fastjson2.JSON;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 给定一组非0整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最小的整数。
 * <p>
 * 注意：
 * <p>
 * 输入整数数组中，可能存在负数，但最多只会有一个负数
 * <p>
 * 输出结果可能非常小，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入格式:
 * 一个整数数组，每个元素其间以“空格”分隔
 * <p>
 * 输出格式:
 * 最小数的字符串
 * <p>
 * 输入样例1:
 * 在这里给出一组输入。例如：
 * <p>
 * 10 2
 */
public class _7_6_最小数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        Integer[] nums = new Integer[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(nums, (l, r) -> {
            if (l < 0) {
                return -1;
            }
            int lk = 10;
            int rk = 10;
            while (lk <= l) {
                lk *= 10;
            }
            while (rk <= r) {
                rk *= 10;
            }
            return (r + l * rk) -  (l + r * lk) ;
        });

        System.out.println(JSON.toJSONString(nums));
        StringBuilder sb = new StringBuilder();
        if (nums[0] < 0) {
            sb.append(nums[0]);
            for (int i = nums.length - 1; i > 0; i--) {
                sb.append(nums[i]);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
            }
        }

        System.out.println(sb);

    }


}
