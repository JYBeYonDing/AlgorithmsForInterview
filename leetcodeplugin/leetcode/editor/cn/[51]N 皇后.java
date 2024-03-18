import java.util.ArrayList;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(ArrayList<String> board, int row) {
        if (row >= board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }
        int n = board.size();
        String s = board.get(row);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            charArray[i] = 'Q';
            board.set(row, String.valueOf(charArray));
            backtrack(board, row + 1);
            charArray[i] = '.';
            board.set(row, s);
        }
    }

    public boolean isValid(ArrayList<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
            int col1 = col - (row - i);
            if (col1 < board.size() && col1 >= 0 && board.get(i).charAt(col1) == 'Q') {
                return false;
            }
            int col2 = col + (row - i);
            if (col2 < board.size() && col2 >= 0 && board.get(i).charAt(col2) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
