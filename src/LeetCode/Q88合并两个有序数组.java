package LeetCode;

/**
 * Created by James on 2018/9/4 10:25.
 */
public class Q88合并两个有序数组 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = 0;
        int indexN = 0;
        int[] merge = new int[m + n];
        int index = 0;
        while (indexM < m && indexN < n) {
            if (nums1[indexM] <= nums2[indexN]) {
                merge[index++] = nums1[indexM++];
            } else {
                merge[index++] = nums2[indexN++];
            }
        }
        while (indexM < m) {
            merge[index++] = nums1[indexM++];
        }
        while (indexN < n) {
            merge[index++] = nums2[indexN++];
        }

//        for (int i = 0; i < merge.length; i++) {
//            nums1[i] = merge[i];
//        }

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }
}
