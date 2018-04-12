package 练习.快排;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/4/12 14:49.
 */
public class 练习4 {
    private static void quickSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int end = nums.length - 1;
        quickSortUnRec(nums,0,end);
    }

    private static void quickSortUnRec(int[] nums, int start, int end) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            int p = partition(nums, start, end);
            if (p - 1 > start) {
                stack.push(start);
                stack.push(p - 1);
            }
            if (p + 1 < end) {
                stack.push(p + 1);
                stack.push(end);
            }
        }
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int less = start - 1;
        int more = end;
        while (true) {
            while (nums[++less] < pivot) {
            }
            while (less < more && nums[--more] > pivot) {
            }
            if (less < more) {
                swap(nums, less, more);
            } else {
                break;
            }
        }
        swap(nums, less, end);
        return less;
    }

    private static void swap(int[] nums, int i, int j) {
        //注意！！！这里不要用异或，因为如果i和j相等，异或就出错了。
//        nums[i]=nums[i] ^ nums[j];
//        nums[j]=nums[i] ^ nums[j];
//        nums[i] =nums[i] ^nums[j];
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 5, 6, 0, 0, 8, 9, 4, 2, 1, 5, 0, 6, 6};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
