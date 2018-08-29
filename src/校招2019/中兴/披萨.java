package 校招2019.中兴;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * Created by James on 2018/8/28 10:57.
 */
public class 披萨 {
    public static void main(String[] args) {
        List<Integer> orders = new ArrayList<>();
        orders.add(-11);
        orders.add(-2);
        orders.add(19);
        orders.add(37);
        orders.add(64);
        orders.add(-18);
        List<Integer> res = pizza(6, 3, orders);
        for (int i : res) {
            System.out.println(i);
        }
    }

    static List<Integer> pizza(int numOfOrders, int size, List<Integer> orders){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numOfOrders; i++) {
            queue.offer(orders.get(i));
            if (queue.size() == size) {
                getMeat(res, queue);
                queue.remove();
            }
        }
        return res;
    }

    static private void getMeat(List<Integer> res, Queue<Integer> queue) {
        for (int i : queue) {
            if (i < 0) {
                res.add(i);
                return;
            }
        }
        res.add(0);
    }
}
