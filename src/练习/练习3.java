package 练习;

/**
 * Created by 杨杰 on 2018/4/10 11:58.
 * 12:05完成
 */
public class 练习3 {


    public static void main(String[] args) {
        int[] nums = {0};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] nums) {
        recQuickSort(nums, 0, nums.length - 1);
    }

    private static void recQuickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }

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
        recQuickSort(nums, start, startIdx - 1);
        recQuickSort(nums, startIdx+1, end);

    }

    private static void swap(int[] nums, int startIdx, int endIdx) {
        int temp = nums[startIdx];
        nums[startIdx] = nums[endIdx];
        nums[endIdx] = temp;
    }
}
