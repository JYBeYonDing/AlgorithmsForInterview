package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 假设你有x元钱，一支钢笔a元，一支铅笔b元。你可以花费部分或者全部的钱，购买任意数目的两种笔（注：购买0支也是允许的）。
 * <p>
 * 请返回购买钢笔和铅笔的所有可能的方案有多少种。
 * <p>
 * 其中，x、a、b均为正整数，且小于1e6。
 * <p>
 * 例如x=20，a=10，b=5，则：
 * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
 * <p>
 * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
 * <p>
 * - 如果你买 2 支钢笔，那么你只能买0支铅笔。
 * <p>
 * <p>
 * 输入格式:
 * x,a,b
 * <p>
 * 例如：20,10,5
 * <p>
 * 输出格式:
 * 方案数
 * <p>
 * 例如：9
 */
public class _7_28_买钢笔和铅笔的方案数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(",");
        int x = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);
        long res = 0;
        for (int i = 0; i <= x / a; i++) {
            res += (x - i * a) / b + 1;
        }
        System.out.println(res);
    }


}
