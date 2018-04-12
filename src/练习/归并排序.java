package 练习;

/**
 * Created by 杨杰 on 2018/4/12 15:55.
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] nums = {0, 6, 3,9,9,7,8,5,3,7};
        Sort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    private static void Sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeSort(nums, 0, nums.length-1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        //注意！！！ 位移运算符 的优先级要低于 加减运算符
        int mid = start + ((end - start) >> 1);
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums,start,mid,end);
    }
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int ih = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
//            if (nums[left] <= nums[right]) {
//                help[ih++] = nums[left++];
//            } else {
//                help[ih++] = nums[right++];
//            }
            help[ih++] = (nums[left] <= nums[right])?nums[left++]:nums[right++];
        }
        while (left <= mid) {
            help[ih++] = nums[left++];
        }
        while (right <= end) {
            help[ih++] = nums[right++];
        }
        for(int i = 0 ; i < help.length ; i++) {
            nums[start++] = help[i];
        }
    }


}
