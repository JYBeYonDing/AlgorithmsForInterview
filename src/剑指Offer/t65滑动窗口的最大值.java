package 剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by 杨杰 on 2018/6/13 16:26.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class t65滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();//存放的是下标，表示有没有过期
        ArrayList<Integer> result = new ArrayList<>();
        if (size <= 0 || num.length < size) {
            return result;
        }
        for(int i=0;i<num.length;i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - size) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= size-1) {
                result.add(num[deque.peekFirst()]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = maxInWindows(num, 3);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
