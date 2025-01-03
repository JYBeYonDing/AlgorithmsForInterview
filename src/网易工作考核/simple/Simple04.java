package org.example.simple;

import java.util.*;

/**
 * 跳跃
 * 分数 30
 * 作者 
 * 单位 
 * Drizzle 被困到一条充满数字的方块路中，假设这条路由一个非负的整数数组m组成，Drizzle 最开始的位置在下标 start 处，当他位于下标i位置时可以向前或者向后跳跃m[i]步数，已知元素值为0处的位置是出口，且只能通过出口出去，不可能数组越界，也不能折返，如果跳跃的步数超出数组范围，则也定义为失败，请你通过编程计算出Drizzle能否逃出这里。
 *
 * 输入格式:
 * 第一行输入数组m的长度n ；第二行输入数组元素，空格分割开 第三行输入起始下标 start
 *
 *
 * 范围：
 *
 * 1 <= m.length <= 5 * 10^4
 *
 * 0 <= m[i] < m.length
 *
 * 0 <= start < m.length
 *
 * 输出格式:
 * True 或 False。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 7
 * 4 2 3 0 3 1 2
 * 5
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * True
 */
public class Simple04 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int[] arr = new int[l];

        for(int i = 0; i< l;i++) {
            arr[i] = in.nextInt();
        }

        int s = in.nextInt();

        in.close();

        boolean[] v = new boolean[l];
        boolean result = dfs(arr, s, v);

        System.out.println(result?"True":"False");
    }

    private static boolean dfs(int[] arr, int start, boolean[] v) {
        if(start < 0 || start >= arr.length || v[start]) {
            return false;
        }

        if(arr[start] == 0) {
            return true;
        }

        v[start] = true;

        int step = arr[start];

        return dfs(arr, start + step, v) ||  dfs(arr, start - step, v);

    }
}
