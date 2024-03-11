
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip: trips) {
            int left = trip[1];
            int right = trip[2];

            diff[left] = diff[left] + trip[0];
            if (right < 1001) {
                diff[right] = diff[right] - trip[0];
            }
        }
        int[] result = new int[1001];
        result[0] = diff[0];
        for (int i = 1; i < 1001; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        for (int i = 0; i < 1001; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
