package org.example.simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 背包能装的最大价值
 * 分数 30
 * 作者 
 * 单位 
 * 给定n个物品和一个容量为C的背包，物品i的重量是Wi，其价值为Vi，背包问题是如何选择入背包的物品，使得装入背包的物品的总价值最大。
 *
 * 注意：你可以将物品的一部分装入背包，但不能重复装入。
 *
 *
 * 输入格式:
 * 每个测试用例三行，每行之间用逗号“,”分隔。
 *
 * 第一行包括两个数字，分别代表物品数n和背包容量C。
 *
 * 第二行输入的是n个数，代表的是物品的重量；第三行输入的是n个数，代表的是物品的价值.
 *
 * 输出格式:
 * 对于每一组测试用例，请输出最大的价值，注意输出格式为整数，小数部分直接舍去。
 *
 * （特别注意：小数部分不是四舍五入，是直接不要，比如14.99，最终输出为14）
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 3,50
 * 10,20,30
 * 60,100,120
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 240
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 5,6
 * 2,8,5,2,1
 * 4,6,3,8,2
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 14
 */
public class Simple23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //分开行的单独读取会存在异常
        String[] arr = in.nextLine().split(",");

        int n = Integer.parseInt(arr[0]);
        int c = Integer.parseInt(arr[1]);

        String[] ws = in.nextLine().split(",");
        String[] ps = in.nextLine().split(",");

        in.close();

        Item[] items = new Item[n];
        for(int i = 0; i < n; i++) {
            items[i] = new Item(Integer.parseInt(ws[i]), Integer.parseInt(ps[i]));
        }
        Double maxPrice = 0D;

        Arrays.sort(items);

        int currWeight = 0;
        int i = 0;
        while(currWeight < c && i < n) {
            if(currWeight + items[i].w <= c) {
                maxPrice += items[i].p;
                currWeight += items[i++].w;
            } else {
                //放一部分
                maxPrice += (c - currWeight) * items[i].v;
                break;
            }
        }

        System.out.println(maxPrice.intValue());
    }

    private static class Item implements Comparable<Item> {
        int w;
        int p;
        //单位价值
        double v;

        public Item(int w, int p) {
            this.w = w;
            this.p = p;
            this.v = (double)p / (double)w;
        }

        @Override
        public int compareTo(Item b) {
            return Double.compare(b.v,this.v);
        }
    }
}
