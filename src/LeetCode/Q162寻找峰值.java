package LeetCode;

/**
 * Created by 杨杰 on 2018/8/9 20:46.
 */
public class Q162寻找峰值 {
    public static void mainx(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3}));
    }

    // 二分法
    public static int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right=mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    //***********************************************************************
    // 二维数组寻找峰值
    // Function to find the maximum in column 'mid'
    // 'rows' is number of rows.
    static int findMax(int[][] arr, int rows, int mid) {
        // 感觉这里也可以用二分查找，降低复杂度
        int max_index = 0;
        int max =0;
        for (int i = 0; i < rows; i++) {
            if (max < arr[i][mid]) {
                // Saving global maximum and its index
                // to check its neighbours
                max = arr[i][mid];
                max_index = i;
            }
        }
        return max_index;
    }

    static int findPeakRec(int[][] arr, int rows, int columns, int mid) {
        // Evaluating maximum of mid column. Note max is
        // passed by reference.
        int max_index = findMax(arr, rows, mid);
        int max = arr[max_index][mid];

        // If we are on the first or last column,
        // max is a peak
        if (mid == 0 || mid == columns-1)
            return max;

        // If mid column maximum is also peak
        if (max >= arr[max_index][mid-1] &&
                max >= arr[max_index][mid+1])
            return max;

        // If max is less than its left
        if (max < arr[max_index][mid-1])
            return findPeakRec(arr, rows, columns, mid - mid/2);

        // If max is less than its left
        // if (max < arr[max_index][mid+1])
        return findPeakRec(arr, rows, columns, mid+mid/2);
    }

    // A wrapper over findPeakRec()
    static int findPeak(int[][] arr, int rows, int columns) {
        return findPeakRec(arr, rows, columns, columns/2);
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 10, 8, 10, 10 },
                { 14, 17, 12, 11 },
                { 15, 9, 11, 11 },
                { 16, 15, 10, 10 } };

        // Number of Columns
        int rows = 4, columns = 4;
        System.out.println(findPeak(arr, rows, columns));
    }
}
