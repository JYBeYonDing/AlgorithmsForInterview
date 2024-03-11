
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int leftBound = 0;
        int rightBound = n - 1;
        int upperBound = 0;
        int lowBound = n - 1;
        int[][] result = new int[n][n];
        int num = 1;
        while (leftBound <= rightBound && upperBound <= lowBound) {
            if (upperBound <= rightBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    result[upperBound][i] = num++;
                }
                upperBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowBound; i++) {
                    result[i][rightBound] = num++;
                }
                rightBound--;
            }
            if (upperBound <= rightBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    result[lowBound][i] = num++;
                }
                lowBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = lowBound; i >= upperBound; i--) {
                    result[i][leftBound] = num++;
                }
                leftBound++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
