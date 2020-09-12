/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i]) {
                continue;
            }
            res++;
            dfs(M, i, visited);
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                dfs(M, j, visited);
            }
        }
    }
}
// @lc code=end

