package org.example.simple;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 丢失的数字
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个包含 [0, n] 中 n 个无重复数的整数数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个整数。
 *
 * 输入格式:
 * 输入数组nums元素，以空格分开
 *
 * 输入数组长度一定为n，且每个输入元素>=0, <=n
 *
 * n<=1000
 *
 * 输出格式:
 * 输出没有出现在数组中的那一个整数
 * 若内容输入错误（数组长度错误，元素范围错误），则结果返回-1
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 3 0 1
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 2
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 3 5 7 9
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * -1
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * 0 1 2 3 4 5 6 7 8
 * 输出样例3:
 * 在这里给出相应的输出。例如：
 *
 * 9
 */
public class Simple37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String num = in.nextLine();
        in.close();

        //边界
        if("".equals(num.trim())) {
            System.out.println(-1);
            return;
        }

        int max = -1;
        Set<Integer> set = new HashSet<>();
        for(String i : num.split(" ")) {
            int x = Integer.parseInt(i);
            set.add(x);
            if(x > max) {
                max = x;
            }
        }

        //异常
        if(set.size() < max) {
            System.out.println(-1);
            return;
        }

        //找数
        int n = set.size();
        for(int i = 0; i <= n; i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
