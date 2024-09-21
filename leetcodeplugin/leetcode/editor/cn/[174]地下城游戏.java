
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] mem;

    int[][] dun;

    int n;

    int m;

    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        mem = new int[n][m];
        dun = dungeon;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mem[i][j] = -1;
            }
        }
        return dp(0, 0);
    }

    private int dp(int i, int j) {
        if (i > 0 && i < n && j > 0 && j < m) {
            if (mem[i][j] != -1) {
                return mem[i][j];
            }
        }

        int min;
        if (i + 1 >= n && j + 1 >= m) {
            min = 1;
        } else if (j + 1 >= m) {
            min = dp(i + 1, j);
        } else if (i + 1 >= n) {
            min = dp(i, j + 1);
        } else {
            min = Math.min(dp(i + 1, j), dp(i, j + 1));
        }

        int res = min <= dun[i][j] ? 1 : min - dun[i][j];
        mem[i][j] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
