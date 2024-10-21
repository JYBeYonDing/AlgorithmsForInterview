package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 对于给定的正整数k，将其表示为一个正整数序列之和，且该序列中相邻元素的差值为等差分布（等差分布从1开始，差值为1，即1,2,3,...,）
 *
 * 注意：请打印出所有可能的序列（打印多个序列时，按照首个数字从小到大依次打印）
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
 */
public class _7_6_数字拆分求和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        boolean res = false;
        for (int x = 1; x <= k / 2; x++) {
            int sum = 0;
            String str = "";
            int num = x;
            int dif = 1;
            while (sum < k) {
                sum += num;
                if (sum == k) {
                    str += num;
                    if (res) {
                        System.out.println();
                    }
                    System.out.print(str);
                    res = true;
                    continue;
                }
                str += num + ",";
                num = num + dif;
                dif += 1;
            }
        }
        if (!res) {
            System.out.print("");
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i=1;i<=k/2;i++){
            int sum=0;
            int dif=0;
            int num = i;
            StringBuilder sb = new StringBuilder();
            while(sum<k){
                sum += num;
                sb.append(num).append(",");
                if(sum==k){
                    // 打印
                    System.out.println(sb.substring(0,sb.length()-1));
                }else{
                    dif+=1;
                    num+=dif;
                }
            }
        }
    }
}
