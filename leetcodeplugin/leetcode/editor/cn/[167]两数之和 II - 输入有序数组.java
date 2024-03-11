
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tempSum = numbers[left] + numbers[right];
            if ( tempSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (tempSum > target) {
                right--;
            } else if (tempSum < target) {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
