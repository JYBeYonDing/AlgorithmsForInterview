package LeetCode;

/**
 * Created by 杨杰 on 2018/7/13 23:26.
 * 没做
 */
public class Q4两个排序数组的中位数 {
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m==0) {
            if (n%2 != 0)//奇数
                return nums2[n/2];
            return (nums2[n/2]+nums2[n/2-1])/2.0;
        }
        if (n==0) {
            if (m%2 != 0)
                return nums1[m/2];
            return (nums1[m/2]+nums1[m/2-1])/2.0;
        }

        int total = (m+n+1)/2;// 需要求两个，如果如果m+n为奇数，total=total2
        int total2 = (m+n+2)/2;

        return (findKth(nums1,0,nums2,0,total)+ findKth(nums1,0,nums2,0,total2))/2.0;
    }

    double findKth(int[] a, int aBegin, int[] b, int bBegin, int k) {
        if (aBegin > a.length-1)
            return b[bBegin+k-1];
        if (bBegin > b.length-1)
            return a[aBegin+k-1];
        if (k == 1)
            return Math.min(a[aBegin],b[bBegin]);

        int midA = Integer.MAX_VALUE;
        int midB = Integer.MAX_VALUE;
        if (aBegin+k/2-1 < a.length)
            midA = a[aBegin+k/2-1];
        if (bBegin+k/2-1 < b.length)
            midB = b[bBegin+k/2-1];

        if (midA < midB)
            return findKth(a,aBegin+k/2,b,bBegin,k-k/2);
        return findKth(a,aBegin,b,bBegin+k/2,k-k/2);
    }
}
