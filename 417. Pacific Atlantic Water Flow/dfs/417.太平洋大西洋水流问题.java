/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
public class Solution {
    static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific, i, 0, m, n);
            dfs(matrix, i, n - 1, atlantic, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, pacific, 0, i, m, n);
            dfs(matrix, m - 1, i, atlantic, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int preI, int preJ, int m,
            int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] < matrix[preI][preJ]
                || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            dfs(matrix, x, y, visited, i, j, m, n);
        }
    }
}

// @lc code=end

