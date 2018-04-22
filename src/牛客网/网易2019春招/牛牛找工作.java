package 牛客网.网易2019春招;

import edu.princeton.cs.algs4.In;
import 程序员面试指南.链表问题.有序链表公共部分.PublicLink;

import java.util.*;

/**
 * Created by 杨杰 on 2018/4/21 15:32.
 * AC 16:30
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
 * 牛牛选工作的标准是在难度不超过自身能力值的情况下，
 * 牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，
 * 牛牛依然使用自己的标准来帮助小伙伴们。
 * 牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 输入描述:
 每个输入包含一个测试用例。
 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 保证不存在两项工作的报酬相同。


 输出描述:
 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

 输入例子1:
 3 3
 1 100
 10 1000
 1000000000 1001
 9 10 1000000000

 输出例子1:
 100
 1000
 1001
 */
public class 牛牛找工作 {
    public static class Job {
        public int d;
        public int p;

        public Job(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    public static class Friend {
        public int index;
        public int ai;
        public Job job;

        public Friend(int index,int ai) {
            this.index = index;
            this.ai = ai;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
//        TreeMap<Integer, Integer> jobs = new TreeMap<>();
        int di = 0;
        int pi = 0;
        // 难度小根堆
        PriorityQueue<Job> dMinHeap = new PriorityQueue<>(new MinDCompator());
        //报酬大根堆
        PriorityQueue<Job> pMxnHeap = new PriorityQueue<>(new MaxPCompator());
        for(int i = 0;i <N; i++) {
            di = sc.nextInt();
            pi = sc.nextInt();
            Job job = new Job(di, pi);
            dMinHeap.add(job);
        }
        int ai = 0;
        int[] res = new int[M];
        Friend[] friends = new Friend[M];
        for(int i=0;i<M;i++) {
            ai = sc.nextInt();
            friends[i] = new Friend(i, ai);
        }
        Arrays.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o1.ai - o2.ai;
            }
        });
        for(int i = 0 ; i< friends.length; i++) {
            while (!dMinHeap.isEmpty() && dMinHeap.peek().d <= friends[i].ai) {
                pMxnHeap.add(dMinHeap.poll());
            }
            friends[i].job = pMxnHeap.peek();
        }
        Arrays.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o1.index-o2.index;
            }
        });
        for(int i = 0 ; i< friends.length ; i++) {
            if (friends[i].job != null) {
                System.out.println(friends[i].job.p);
            } else {
                System.out.println(0);
            }
        }
    }

    public static class MinDCompator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.d-o2.d;
        }
    }
    public static class MaxPCompator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o2.p-o1.p;
        }
    }

}
