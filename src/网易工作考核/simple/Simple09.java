package org.example.simple;

import java.util.Scanner;

/**
 * 最小硬币个数
 * 分数 30
 * 作者 
 * 单位 
 * 假设现在有一堆硬币，其中有足够个1元硬币、足够个2元硬币和足够个5元硬币。现在需要用这些硬币凑出总价值为n元的钱，求最少需要多少枚硬币？
 *
 * 输入格式:
 * 每一组输入为一行，代表需要凑出的钱的价值n。其中0<=n<=2147483647
 *
 * 输出格式:
 * 对每一组输入，在一行中输出需要的硬币的值。如果不能凑出指定价值，请返回0。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 0
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 0
 *
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 100
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 20
 *
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * 14
 * 输出样例3:
 * 在这里给出相应的输出。例如：
 *
 * 4
 */
public class Simple09 {

    public static void main(String[] args) {
        //read
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        in.close();
        if(sum <=0 ) {
            System.out.println(-1);
            return;
        }

        //贪婪法
        System.out.println(sum / 5  + (sum  % 5) / 2 + (sum % 5) % 2);
    }
}
