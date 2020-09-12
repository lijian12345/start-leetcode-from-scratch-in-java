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
            bfs(M, i, visited);
        }
        return res;
    }

    private void bfs(int[][] M, int i, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < M.length; v++) {
                if (!visited[v] && M[u][v] == 1) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
    }
}
// @lc code=end

