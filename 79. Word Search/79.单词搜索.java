/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    int rows, cols;
    boolean[][] isVisited;
    char[][] board;
    String word;
    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.isVisited = new boolean[rows][cols];
        this.board = board;
        this.word = word;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int row, int col) {
        if (i == word.length()) {
            return true;
        }
        if (notInArea(row, col) || isVisited[row][col] || board[row][col] != word.charAt(i)) {
            return false;
        }
        isVisited[row][col] = true;
        // 注意剪枝
        for (int[] direction : directions) {
            if (dfs(i + 1, row + direction[0], col + direction[1])) {
                return true;
            }
        }
        isVisited[row][col] = false;
        return false;
    }

    private boolean notInArea(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}
// @lc code=end

