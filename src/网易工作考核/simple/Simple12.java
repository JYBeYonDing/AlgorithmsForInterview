package org.example.simple;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 无法吃午餐的学生数量
 * 分数 30
 * 作者 
 * 单位 
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 *
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 *
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 输入格式:
 * 两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i​​​​​​ 个三明治的类型（i = 0 是栈的顶部）， students[j] 是初始队列里第 j​​​​​​ 名学生对三明治的喜好（j = 0 是队列的最开始位置）。
 *
 * 第一行为students，以空格分隔
 *
 * 第二行为sandwiches，以空格分隔
 *
 * 输出格式:
 * 无法吃午餐的学生数量。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1 1 0 0
 * 0 1 0 1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 0
 * 注意事项：
 * 1 <= students.length, sandwiches.length <= 100
 *
 * students.length == sandwiches.length
 *
 * sandwiches[i] 要么是 0 ，要么是 1 。
 *
 * students[i] 要么是 0 ，要么是 1 。
 */
public class Simple12 {
    public static void main(String[] args) {
        // read input
        Scanner in = new Scanner(System.in);

        String students = in.nextLine();
        String sandwiches = in.nextLine();

        in.close();

        String[] ss = students.split(" ");
        LinkedList<String> linkedList = new LinkedList<>();
        for(String s: ss) {
            linkedList.addLast(s);
        }

        String[] sw = sandwiches.split(" ");
        int swidx = 0;

        int cnt = 0;
        while(swidx < sw.length) {
            String s = linkedList.pollFirst();
            if(s.equals(sw[swidx])) {
                swidx++;
                cnt = 0;
            } else {
                linkedList.addLast(s);
                cnt++;
            }
            if(cnt >= linkedList.size()) {
                break;
            }
        }

        System.out.println(linkedList.size());
    }
}
