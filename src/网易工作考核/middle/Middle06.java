package org.example.middle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小数
 * 分数 30
 * 作者 
 * 单位 
 * 给定一组非0整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最小的整数。
 *
 * 注意：
 *
 * 输入整数数组中，可能存在负数，但最多只会有一个负数
 *
 * 输出结果可能非常小，所以你需要返回一个字符串而不是整数。
 *
 * 输入格式:
 * 一个整数数组，每个元素其间以“空格”分隔
 *
 * 输出格式:
 * 最小数的字符串
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 10 2
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 102
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 3 30 34 5 -9
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * -9534330
 */
public class Middle06 {
    public static void main(String[] args) {

        // read input
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        //是否有负数
        boolean negative = line.contains("-");
        String[] nums = line.split(" ");

        //自定义排序
        Arrays.sort(nums, (a, b)->{
            //负数排在最后面
            if(a.startsWith("-")) {
                //a.compareTo(b) = 1;
                return 1;
            } else if (b.startsWith("-")) {
                //a.compareTo(b) = -1;
                return -1;
            }

            //长度相等,直接比较
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }

            //按最后一个数字补齐长度,再比较
            String c = null;
            if(a.length() > b.length()) {
                c = b;
                String t = b.substring(b.length() - 1);
                while(c.length() < a.length()) {
                    c = c + t;
                }
                return a.compareTo(c);
            } else {
                c = a;
                String t = a.substring(a.length() - 1);
                while(c.length() < b.length()) {
                    c = c + t;
                }
                return c.compareTo(b);
            }
        });

        //输出
        if(negative) {
            for(int i = nums.length-1; i >=0; i--) {
                System.out.print(nums[i]);
            }
        } else {
            for(String num : nums) {
                System.out.print(num);
            }
        }
        System.out.println();
    }
}
