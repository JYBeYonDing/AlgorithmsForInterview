package 网易工作考核.简单;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _7_10_求最后一块石头的重量 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            queue.add(nums[i]);
        }
        while (queue.size() > 1) {
            Integer poll1 = queue.poll();
            Integer poll2 = queue.poll();
            if (poll1 > poll2) {
                queue.add(poll1 - poll2);
            }
        }
        if (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }else{
            System.out.println(0);
        }

    }
}
