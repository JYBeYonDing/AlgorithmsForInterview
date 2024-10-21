package org.example.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数字拆分求和
 * 分数 30
 * 作者 
 * 单位 
 * 对于给定的正整数k，将其表示为一个正整数序列之和，且该序列中相邻元素的差值为等差分布（等差分布从1开始）。注意，请打印出所有可能的序列（打印多个序列时，按照首个数字从小到大依次打印）。
 *
 *
 * 例如：
 *
 * 示例1输入：
 *
 * k=26
 *
 * 示例1输出：
 *
 * 4,5,7,10
 *
 * 该序列的和为26，相邻元素的差值为1,2,3
 *
 * 示例2输入：
 * k=55
 *
 * 示例2输出
 *
 * 7,8,10,13,17
 *
 * 17,18,20
 *
 * 27,28
 *
 * 即，有3个序列满足条件，其和均为55，且相邻元素的差值为等差分布（从1开始）
 *
 * 注：若没有满足条件的序列，则打印空串。
 *
 *
 * 输入格式:
 * 正整数k
 *
 * 输出格式:
 * 打印所有满足条件的序列，每行对应1个序列，每个序列的数字间以,相隔。例如k=55，输出为：
 *
 * 7,8,10,13,17
 *
 * 17,18,20
 *
 * 27,28
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 55
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 7,8,10,13,17
 * 17,18,20
 * 27,28
 */
public class Simple07 {


    /**
     * 推导
     *      4  = 4 + 0                 = t + 0
     *      5  = 4 + 1                 = t + 1
     *      7  = 4 + 1 + 2             = t + 1 + 2
     *      10 = 4 + 1 + 2 + 3         = t + 1 + 2 + 3
     *
     *      N = 4 + (1 + 2 + ... + n)  = t + (n * (n + 1) / 2)
     *      nSum = n * (n + 1) * (n + 2) / 6 (数学归纳法)
     *
     *     转换
     *      k = 4 + 5 + 7 + 10 = (n + 1) * t + n * (n+1) * (n+2) / 6
     *      t = (k - n * (n+1) * (n+2) / 6 ) / (n + 1)
     *
     *     条件
     *      6k -n * (n+1) * (n+2) mod (n + 1) * 6 = 0;
     *      n > 0; n 为正整数；n从k开始遍历, t为正整数
     */
    public static void main(String[] args) {

        // read
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        in.close();

        List<String> result = new ArrayList<>();
        for(int n = k; n > 0; n--) {
            if((6 * k - n * (n + 1) * (n + 2)) % ((n + 1)  * 6) == 0) {
                int t = (k - (n * (n + 1) * (n + 2)) / 6) / (n + 1);
                if(t <= 0) {
                    continue;
                }
                result.add(calcThisSeq(t, n + 1));
            }
        }

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static String calcThisSeq(int t, int n) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(String.valueOf(t + i * (i + 1) / 2));
        }

        return String.join(",", list);
    }
}
