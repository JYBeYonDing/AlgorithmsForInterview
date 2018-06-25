package 牛客网.模拟六月场;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/24 21:33.
 * 为了拯救因入学人数骤降，面临废弃的学校，牛牛决定成为偶像啦。当然，作为一个偶像，肯定是要上台表演的。
 已知牛牛拿到了n个上台表演的机会，第i次表演的上台时间为ti时刻，需要表演mi这么长的时间。
 牛牛为了提高自己的知名度，肯定要取得最多的上场次数。请问，牛牛最多能上场多少次呢？
 输入描述:
 第一行输入一个数字n(1≤n≤100000)，表示牛牛获得的上台表演的机会
 接下来n行，每行输入两个数字ti(1≤ti≤108)和mi(1≤mi≤108),
 表示第i次表演机会的上台时间和该次表演需要的总时间（表演途中不能中断表演退出）。
 输出描述:
 牛牛最多能上场的次数。
 输入例子1:
3
1 2
3 2
5 2
 输出例子1:
 3
 */
public class 牛牛偶像养成记 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Show> queue = new PriorityQueue<>(new Comparator<Show>() {
            @Override
            public int compare(Show o1, Show o2) {
                return o1.end-o2.end;
            }
        });
        String[] strs = null;
        for(int i= 0 ; i< n;i++) {
            strs = sc.nextLine().split(" ");
            queue.offer(new Show(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
        }
        int count = 0;
        int lastEnd = 0;
        while (!queue.isEmpty()) {
            Show cur = queue.poll();
            if (cur.start >= lastEnd) {
                count++;
                lastEnd = cur.end;
            }
        }
        System.out.println(count);
    }

    static private class Show {
        int start;
        int duration;
        int end;

        public Show(int start, int duration) {
            this.start = start;
            this.duration = duration;
            this.end = start + duration;
        }
    }
}
