package LeetCode;

/**
 * Created by James on 2018/8/30 10:49.
 */
public class Q200岛屿的个数 {

    boolean[][] visited;
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n,m;
    public int numIslands(char[][] grid) {

        n = grid.length;
        if (n <= 0) {
            return 0;
        }
        m = grid[0].length;

        visited = new boolean[n][m];

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;

                    infect(grid, i, j);
                }

            }
        }
        return res;
    }

    private void infect(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x+d[i][0];
            int newY = y+d[i][1];

            if (inArea(newX, newY) && !visited[newX][newY]&& grid[newX][newY] == '1') {
                infect(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int newX, int newY) {
        return (newX >= 0 && newX < n && newY > 0 && newY < m);
    }
}
