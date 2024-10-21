package org.example.simple;

import java.util.Scanner;

/**
 * 给定数字组成最大时间
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 24 小时格式为HH:MM ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59。
 *
 * 以长度为 5 的字符串，按 HH:MM 格式返回答案。如果不能确定有效时间，则返回空字符串。
 *
 * 输入格式:
 * 4个0~9之间的数字，以,分隔。例如4,2,3,1
 *
 * 输出格式:
 * 23:41
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 4,2,3,1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 23:41
 */
public class Simple16 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String wd = in.nextLine();
        in.close();

        String[] ss = wd.split(",");

        int[] arr = new int[4];
        for(int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        int ans = -1;

        //枚举所有下标可能性
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(j == i) {continue;}
                for(int k = 0; k < 4; k++) {
                    if(k == i || k == j) {continue;}
                    int l = 6 - i - j - k;
                    int hour = arr[i] * 10 + arr[j];
                    int mnts = arr[k] * 10 + arr[l];
                    if(hour < 24 && mnts < 60) {
                        //使用总分钟数代替时分比较
                        ans = Math.max(ans, hour * 60 + mnts);
                    }
                }
            }
        }

        //使用格式化更快捷
        System.out.println(ans == -1 ? "": String.format("%02d:%02d", ans / 60, ans % 60));
    }
}
