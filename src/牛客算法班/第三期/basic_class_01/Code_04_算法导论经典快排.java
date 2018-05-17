package 牛客算法班.第三期.basic_class_01;

import java.util.ArrayDeque;

/**
 * Created by 杨杰 on 2018/5/17 11:22.
 *
 * 算法导论中的经典实现过程
 * 结合算法导论p96 图7-2 图7-3 很容易理解记忆
 */
public class Code_04_算法导论经典快排 {
    private static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickRec(nums, 0, nums.length - 1);
    }

    private static void quickRec(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int indexP = partition(nums, left, right);
        quickRec(nums, left, indexP - 1);
        quickRec(nums, indexP + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int less = left-1;
        for(int index = left ; index<right ; ) {
            if (nums[index] <= pivot) {
                swap(nums, ++less, index);
            }
            index++;
        }
        swap(nums, ++less, right);
        return less;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 非递归版本快排
     * 即实现人工递归栈
     */
    private static void quickSortUnRec(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickUnRec(nums, 0, nums.length - 1);
    }

    private static void quickUnRec(int[] nums, int left, int right) {
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        if (right > left) {
            indexStack.push(right);
            indexStack.push(left);
        }
        while (!indexStack.isEmpty()) {
            int l = indexStack.pop();
            int r = indexStack.pop();
            int indexP = partition(nums, l, r);
            if (indexP + 1 < r) {
                indexStack.push(r);
                indexStack.push(indexP + 1);
            }
            if (indexP - 1 > l) {
                indexStack.push(indexP - 1);
                indexStack.push(l);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 5, 7, 3, 9, 2, 3, 6, 0, 1, 3, 7};
//        quickSort(nums);
        quickSortUnRec(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
