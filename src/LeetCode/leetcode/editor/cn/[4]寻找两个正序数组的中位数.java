
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMidian(nums2);
        }
        if(nums2.length==0){
            return findMidian(nums1);
        }
        int[] nums = new int[nums1.length+nums2.length];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        while (idx1<nums1.length || idx2< nums2.length){
            if(idx1>=nums1.length){
                nums[idx] = nums2[idx2];
                idx2++;
                idx++;
            }else if(idx2>=nums2.length){
                nums[idx] = nums1[idx1];
                idx1++;
                idx++;
            }else{
                if(nums1[idx1]<nums2[idx2]){
                    nums[idx] = nums1[idx1];
                    idx1++;
                }else{
                    nums[idx] = nums2[idx2];
                    idx2++;
                }
                idx++;
            }
        }
        return findMidian(nums);
    }

    private double findMidian(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2] / 1.0;
        } else {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
