/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int rows, cols;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        if (rows == 0 || grid == null) {
            return 0;
        }
        this.cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction : directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
// @lc code=end

