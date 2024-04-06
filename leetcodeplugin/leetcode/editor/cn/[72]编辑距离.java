import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] mem;
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        mem = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        return dp(word1, length1 - 1, word2, length2 - 1);
    }

    /**
     * 0~idx1 转变为 0~idx2的最小距离
     *
     * @param word1
     * @param idx1
     * @param word2
     * @param idx2
     * @return
     */
    private int dp(String word1, int idx1, String word2, int idx2) {
        if (idx1 == -1) {
            return idx2 + 1;
        }
        if (idx2 == -1) {
            return idx1 + 1;
        }
        if (mem[idx1][idx2] != Integer.MAX_VALUE) {
            return mem[idx1][idx2];
        }
        int res;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            res = dp(word1, idx1 - 1, word2, idx2 - 1);
            mem[idx1][idx2] = res;
            return res;
        }
        res = min(dp(word1, idx1, word2, idx2 - 1) + 1, dp(word1, idx1 - 1, word2, idx2 - 1) + 1,
                dp(word1, idx1 - 1, word2, idx2) + 1);
        mem[idx1][idx2] = res;
        return res;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
