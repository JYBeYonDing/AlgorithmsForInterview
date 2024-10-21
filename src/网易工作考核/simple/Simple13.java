package org.example.simple;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 求最后一块石头的重量
 * 分数 30
 * 作者 
 * 单位 
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 *
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 输入格式:
 * 输入一组石头的重量，均为正整数。
 *
 * 输出格式:
 * 输出最后一块石头的重量。如果没有石头剩下，就返回 0。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 2,7,4,1,8,1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 1
 */
public class Simple13 {

    /**
     * PriorityQueue：小顶堆，指定compare （a，b) -> b - a 变成大顶堆
     * @param args
     */
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);
        String arr = in.nextLine();
        in.close();

        String [] ss = arr.split(",");
        // 小顶堆，指定compare （a，b) -> b - a 变成大顶堆
        PriorityQueue<Integer> heap  = new PriorityQueue<>((a,b)-> b-a);
        for(String s : ss) {
            heap.offer(Integer.parseInt(s));
        }

        while(heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if(a != b) {
                heap.offer(a - b);
            }
        }

        System.out.println(heap.isEmpty() ? 0 : heap.poll());
    }
}
