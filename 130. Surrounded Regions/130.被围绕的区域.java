/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    int rows;
    int cols;
    char[][] board;
    boolean[][] isVisited;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        this.board = board;
        this.rows = board.length;
        if (rows == 0) {
            return;
        }
        this.cols = board[0].length;
        this.isVisited = new boolean[rows][cols];
        if (rows <= 2 || cols <= 2) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isEdge = i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';

        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
    }
}
// @lc code=end

