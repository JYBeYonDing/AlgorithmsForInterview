package LeetCode;

/**
 * Created by James on 2018/8/30 10:28.
 */
public class Q79单词搜索 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//偏移量数组
    int m;
    int n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null ) {
            return false;
        }

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {

        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;

            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];

                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }

            visited[startX][startY] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return (x>=0 && x<m && y>=0 && y<n);
    }

}
