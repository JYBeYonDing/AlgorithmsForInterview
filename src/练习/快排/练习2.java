package 练习.快排;

/**
 * Created by 杨杰 on 2018/4/10 11:01.
 */
public class 练习2 {
    private static void quickSort(int[] nums) {
        recQuick(nums, 0, nums.length - 1);
    }

    private static void recQuick(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = nums[end];
        int startIdx = start-1;
        int endIdx = end;
        while (true) {
            while (nums[++startIdx] < pivot) {
                ;
            }
            while (nums[--endIdx] > pivot && endIdx>startIdx) {
            }
            if (startIdx < endIdx) {
                int temp = nums[startIdx];
                nums[startIdx] = nums[endIdx];
                nums[endIdx] = temp;
            } else {
                break;
            }
        }

        int temp = nums[startIdx];
        nums[startIdx] = nums[end];
        nums[end] = temp;
        recQuick(nums,start,startIdx-1);
        recQuick(nums,startIdx+1,end);

    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 5, 7, 3, 9, 2, 3, 6, 0, 1, 3, 7};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
