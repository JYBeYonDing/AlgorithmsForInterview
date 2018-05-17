package 练习;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/5/16 16:51.
 * 完成 17:17
 */
public class 滑动窗口 {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }

    private static void printArray(int[] maxWindow) {
        for (int i : maxWindow) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();
        int[] res = new int[arr.length - w + 1];
        for(int i = 0 ; i<arr.length ; i++) {
            //判断队列中的索引是否过期
            if (!indexQueue.isEmpty()&&(i-w >= indexQueue.peekFirst())) {
                indexQueue.pollFirst();
            }
            // 将队列中索引的数小于当前索引的数取出，因为是最大窗口
            while (!indexQueue.isEmpty() && arr[indexQueue.peekLast()] <= arr[i]) {
                indexQueue.pollLast();
            }
            indexQueue.addLast(i);
            // 长度已经形成窗口则进行取数
            if ((i+1) >= w) {
                res[i+1 - w] = arr[indexQueue.peekFirst()];
            }
        }
        return res;
    }
}
