package Java数据结构和算法.排序.快速排序;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/4/10 12:14.
 */
public class 快排非递归 {
    public static void main(String[] args) {
        int[] nums =  {6, 4, 5, 7, 3, 9, 2, 3, 6, 0, 1, 3, 7};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            int j = partition(nums, start, end);
            if (j - 1 > start) {
                stack.push(start);
                stack.push(j-1);
            }
            if (j + 1 < end) {
                stack.push(j + 1);
                stack.push(end);
            }
        }

    }

//    private static void recQuickSort(int[] nums, int start, int end) {
//        if (end <= start) {
//            return;
//        }
//
//        int j = partition(nums,start,end);
//        recQuickSort(nums, start, j - 1);
//        recQuickSort(nums, j+1, end);
//
//    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int startIdx = start-1;
        int endIdx = end;
        while (true) {
            while (nums[++startIdx] < pivot) {
            }
            while (nums[--endIdx] > pivot && endIdx > startIdx) {
            }

            if (startIdx < endIdx) {
                swap(nums, startIdx, endIdx);
            } else {
                break;
            }
        }
        swap(nums, startIdx, end);
        return startIdx;
    }

    private static void swap(int[] nums, int startIdx, int endIdx) {
        int temp = nums[startIdx];
        nums[startIdx] = nums[endIdx];
        nums[endIdx] = temp;
    }
}
