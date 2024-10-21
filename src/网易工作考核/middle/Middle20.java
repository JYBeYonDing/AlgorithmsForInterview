package org.example.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 根据数字的补数排序
 * 分数 30
 * 作者
 * 单位
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" （没有前导零位），取反后得到 "010" ，再转回十进制表示得到补数 2 。
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其补数升序排序。如果补数相同，则按照原数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 *
 * 0 <= arr[i] <= 10^4
 *
 * 输入格式:
 * 整数数组arr，以",”分隔字符串的形式作为输入
 *
 * 输出格式:
 * 排好序的整数数组，以",”分隔字符串的形式作为输出
 *
 * 输入样例:
 * 原始数组arr：
 *
 * 5,10,4,2
 * 输出样例:
 * 排序后的arr：
 *
 * 2,5,4,10
 */
public class Middle20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        in.close();

        Integer[] nums = new Integer[str.length];
        int i = 0;
        for(String n : str) {
            nums[i++] = Integer.parseInt(n);
        }

        final Map<Integer,Integer> map = complMap(nums);

        Arrays.sort(nums, (a, b)-> {
            if(!map.get(a).equals( map.get(b))) {
                return map.get(a) - map.get(b);
            }
            return a - b;
        });

        System.out.println(Arrays.toString(nums).replaceAll("[\\[ \\]]",""));
    }

    private static Map<Integer,Integer> complMap(Integer[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer n : nums) {
            map.put(n, findCompl(n));
        }
        return map;
    }

    private static int findCompl(int n) {
        int mask = 1;
        while(mask < n) {
            mask <<= 1;
            mask |=  1;
        }
        return mask ^ n;
    }
}
