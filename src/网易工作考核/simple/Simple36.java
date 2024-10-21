package org.example.simple;

import java.util.Scanner;

/**
 * 买钢笔和铅笔的方案数
 * 分数 30
 * 作者 
 * 单位 
 * 假设你有x元钱，一支钢笔a元，一支铅笔b元。你可以花费部分或者全部的钱，购买任意数目的两种笔（注：购买0支也是允许的）。
 *
 * 请返回购买钢笔和铅笔的所有可能的方案有多少种。
 *
 * 其中，x、a、b均为正整数，且小于1e6。
 *
 * 例如x=20，a=10，b=5，则：
 * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
 *
 * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
 *
 * - 如果你买 2 支钢笔，那么你只能买0支铅笔。
 *
 *
 * 输入格式:
 * x,a,b
 *
 * 例如：20,10,5
 *
 * 输出格式:
 * 方案数
 *
 * 例如：9
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 20,10,5
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 9
 */
public class Simple36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] num = in.nextLine().split(",");
        in.close();

        int sum = Integer.parseInt(num[0]);
        int a = Integer.parseInt(num[1]);
        int b = Integer.parseInt(num[2]);

        System.out.println(waysToBuyPensPencils(sum,a,b));
    }

    private static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for(int i = 1; total >= 0; total -= i * cost1) {
            ans += total / cost2 + 1;
        }
        return ans;
    }
}
