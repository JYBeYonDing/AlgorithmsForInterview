package 程序员面试指南.栈和队列.窗口最大值;

import java.util.ArrayDeque;

public class MaxValue {

    public int[] getMaxWindow(int[] arr, int w) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int[] maxWindow = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0 ; i<arr.length ; i++) {
            while (!ad.isEmpty() && arr[ad.peekLast()]<=arr[i]){
                ad.pollLast();
            }
            ad.addLast(i);
            if (ad.pollFirst() <= i - w) {
                ad.pollFirst();
            }
            if (i >= (w - 1)) {
                maxWindow[index++] = arr[ad.peekFirst()];
            }
        }
        return maxWindow;
    }
}
