package org.example.simple;

import java.util.*;

/**
 * 合并 K 个升序链表
 * 分数 30
 * 作者 
 * 单位 
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 * 提示：
 *
 * k == lists.length
 *
 * 0 <= k <= 10^4
 *
 * 0 <= lists[i].length <= 500
 *
 * -10^4 <= lists[i][j] <= 10^4
 *
 * lists[i] 按 升序 排列
 *
 * lists[i].length 的总和不超过 10^4
 *
 * 数值都是整数
 *
 * 输入格式:
 * lists = [[1,4,5],[1,3,4],[2,6]]
 *
 * 输出格式:
 * [1, 1, 2, 3, 4, 4, 5, 6]
 *
 * 格式说明：
 * 输入和输出需要参照以下样例的数据规范
 *
 * 注意：输出数字前有空格（参考样例）；空列表以“[]” 表示
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * [[1,4,5],[1,3,4],[2,6]]
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * [1, 1, 2, 3, 4, 4, 5, 6]
 */
public class Simple24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String narr = in.nextLine();
        in.close();

        //边界情况1
        if("[]".equals(narr)) {
            System.out.println(new LinkedList<>());
            return;
        }

        List<LinkedList<Integer>> list = new ArrayList<>();
        int linkedCnt = 0;
        for(String arr : narr.split("\\],\\[")) {
            arr = arr.replaceAll("[\\[\\]]","");
            //边界情况2
            if("".equals(arr)) {
                continue;
            }
            LinkedList<Integer> linked = new LinkedList<>();
            for(String i : arr.split(",")) {
                linked.addLast(Integer.parseInt(i));
            }
            list.add(linked);
            linkedCnt++;
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int j = 0; j < linkedCnt; j++) {
            if(list.get(j).size() > 0) {
                queue.offer(new Integer[] {list.get(j).peek(),j});
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            Integer[] item = queue.poll();
            LinkedList<Integer> linked = list.get(item[1]);
            result.addLast(linked.poll());
            if(linked.size() > 0) {
                queue.offer(new Integer[] {linked.peek(), item[1]});
            }
        }

        System.out.println(result);
    }
}
