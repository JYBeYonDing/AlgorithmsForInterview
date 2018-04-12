package 练习.快排;

/**
 * Created by 杨杰 on 2018/4/10 8:54.
 * 这个不好，看练习三
 */
public class QuickSork {
    private static void quickSort(int[] nums) {
        recSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void recSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = nums[end];
        int startIdx = start;
        int endIdx = end - 1;
        while (true) {
            while (nums[startIdx] < pivot) {
                startIdx++;
            }
            while (nums[endIdx] > pivot && endIdx > startIdx) {
                endIdx--;
            }
            if (startIdx < endIdx) {
                int temp = nums[startIdx];
                nums[startIdx] = nums[endIdx];
                nums[endIdx] = temp;
                startIdx++;//交换之后，这两个就不用再判断了,为了省去这边两步可以改变循环中++ -- 的位置。
                endIdx--;
            }else{
                break;
            }
        }
        /**
         * 最后只剩下两个元素时一定要注意！！！！！
         * 一开始这里要写一个判断语句是因为在最后只有两个元素时，
         * 如果上面的循环中，判断条件是startIdx<endIdx，没有break，就会出现重复交换，从而导致没有交换。
         */
//        if (nums[startIdx] >= nums[end]) {
            int temp = nums[startIdx];
            nums[startIdx] = nums[end];
            nums[end] = temp;
//        }
        recSort(nums, start, startIdx - 1);
        recSort(nums, startIdx + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 5, 7, 3, 9, 2, 6,6,9,7,5,6};
        quickSort(nums);
    }
}
