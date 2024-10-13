package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * 输入格式:
 * 每个测试用例为一行，代表需要到达的楼顶层数n，其中1<=n<=45
 * <p>
 * 输出格式:
 * 对每一组输入，输出可以爬到楼顶的方法数量
 */
public class _7_19_爬阶梯问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] step = new int[n+1];
        step[0] = 1;
        step[1] = 1;
        for (int i = 2; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }

        System.out.println(step[n]);
    }


}
