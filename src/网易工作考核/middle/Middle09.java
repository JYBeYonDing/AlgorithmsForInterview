package org.example.middle;

import java.util.Scanner;

/**
 * 知道秘密的人数
 * 分数 30
 * 作者
 * 单位
 * 题目描述
 *
 * 在第 1 天，有一个人发现了一个秘密。
 *
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 *
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对  10^9+7  取余 后返回。
 *
 * 输入格式:
 * 输入在一行，包含n, delay, forget，以空格分隔
 *
 * 输出格式:
 * 输出最后的数值
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 6 2 4
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 5
 * 解释
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 *
 * 注意事项
 * 2 <= n <= 1000
 *
 * 1 <= delay < forget <= n
 */
public class Middle09 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int delay = in.nextInt();
        int forget = in.nextInt();

        // 10 ^ 9 +7
        long mod = 1000000007L;

        // result[i] 表示知道秘密i天的人的总合
        long[] result = new long[forget + 1];
        //第一天只有一个人知道秘密
        result[1] = 1;
        // 从第二天开始
        for(int i = 1; i < n; i++) {
            // 天数+1, 数据向后平移
            for(int j = forget; j > 0; j--) {
                result[j] = result[j - 1];
            }
            // 计算第一天知道秘密的人的总和
            long temp = 0L;
            // 从delay+1天开始，到forget天, 前面的人都还没开始分享, 后面的人都忘记了
            for(int k = delay + 1; k <= forget; k++) {
                temp += result[k];
            }
            result[1] = temp % mod;
        }

        // 计算知道秘密i天的人的总和
        long sum = 0L;
        for(long l : result) {
            sum += l;
        }
        sum = sum % mod;

        System.out.println(sum);
    }
}
