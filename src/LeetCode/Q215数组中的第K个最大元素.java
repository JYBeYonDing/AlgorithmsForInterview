package LeetCode;

/**
 * Created by James on 2018/9/4 10:35.
 */
public class Q215数组中的第K个最大元素 {


    public int findKthLargest(int[] nums, int k) {


        int start = 0;
        int end = nums.length - 1;
        while (k >= 1 && k <= nums.length) {
            //给[start,end] 进行partition过程后nums[end]处于位置p(p取值[0,nums.length-1])
            int[] p = partition(nums, start, end);

            if (p[0]+1<=k && k<=p[1]+1) {
                return nums[p[0]];
            } else if (p[1] + 1 < k) {
                start = p[1] + 1;
            } else {
                end = p[0]-1;
            }
        }
        return -1;
    }

    private int[] partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int more = start-1;//[start,more]>pivot

        int less = end;//[less,end]<pivot

        while (start < less) {
            if (nums[start] > pivot) {
                more++;
                swap(nums, more, start);
                start++;
            } else if (nums[start] < pivot) {
                less--;
                swap(nums, less, start);
            } else {
                start++;
            }
        }
        swap(nums, less, end);

        return new int[]{more+1,less};
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }


    public static void main(String[] args) {
        Q215数组中的第K个最大元素 dikda = new Q215数组中的第K个最大元素();
        System.out.println(dikda.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
