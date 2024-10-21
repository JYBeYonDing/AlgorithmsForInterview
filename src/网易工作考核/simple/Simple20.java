package org.example.simple;

import java.util.*;

/**
 * 滑动窗口最大值
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 注：k小于len(nums)
 *
 * 输入格式:
 * 整数数组nums，以及滑动窗口大小k
 *
 * 第一行为nums，以空格分隔
 *
 * 第二行为k
 *
 * 输出格式:
 * 一行整数，包含每个窗口中的最大值，以空格分隔
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1 3 -1 -3 5 3 6 7
 * 3
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3 3 5 5 6 7
 * 解释：
 * 步骤	滑动窗口的位置	最大值
 * 0	[1 3 -1] -3 5 3 6 7	3
 * 1	1 [3 -1 -3] 5 3 6 7	3
 * 2	1 3 [-1 -3 5] 3 6 7	5
 * 3	1 3 -1 [-3 5 3] 6 7	5
 * 4	1 3 -1 -3 [5 3 6] 7	6
 * 5	1 3 -1 -3 5 [3 6 7]	7
 * 注意事项
 * 1 <= nums.length <= 10^5
 *
 * -10^4<= nums[i] <=10^4
 *
 * 1 <= k <= nums.length
 */
public class Simple20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> list1 = new LinkedList<>();
        while(in.hasNextInt()) {
            list1.addLast(in.nextInt());
        }
        in.close();

        int k = list1.pollLast();

        //链表访问转随机访问，否则超时
        List<Integer> list = new ArrayList<>(list1);

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a,b) -> {
            return a[0] != b[0] ? b[0]- a[0] : b[1] - a[1];
        });

        for(int i = 0; i < k; i++){
            queue.offer(new Integer[] {list.get(i), i});
        }

        //为了快速拼接
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(queue.peek()[0]));

        for(int i = k; i < list.size(); i ++ ){
            queue.offer(new Integer[] {list.get(i), i});
            //这里需要出队所有不在窗口中的元素
            while(queue.peek()[1] < i - k + 1) {
                queue.poll();
            }
            result.add(String.valueOf(queue.peek()[0]));
        }

        System.out.println(String.join(" ", result));
    }
}
