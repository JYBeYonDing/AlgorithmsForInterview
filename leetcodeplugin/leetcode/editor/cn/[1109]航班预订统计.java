
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking: bookings) {
            int left = booking[0] - 1;
            int right = booking[1] - 1;
            int num = booking[2];
            diff[left] = diff[left] + num;
            if (right < n - 1) {
                diff[right + 1] = diff[right + 1] - num;
            }
        }
        int[] result = new int[n];
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
