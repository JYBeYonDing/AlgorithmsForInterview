
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0);
        return result;
    }

    public void backtrack(int[][] board, int row) {
        if (row >= board.length) {
            result++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!valid(board, row, i)) {
                continue;
            }
            board[row][i] = 1;
            backtrack(board, row + 1);
            board[row][i] = 0;
        }
    }

    public boolean valid(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
            int col1 = col - (row - i);
            if (col1 >= 0 && col < board.length && board[i][col1] == 1) {
                return false;
            }
            int col2 = col + (row - i);
            if (col2 >= 0 && col2 < board.length && board[i][col2] == 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
