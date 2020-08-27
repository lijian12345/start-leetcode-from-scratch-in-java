/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {i, 0});
        }
        int res = 0;
        while (k > 0) {
            int[] t = pq.poll();
            k--;
            int i = t[0], j = t[1];
            res = matrix[i][j];
            if (j + 1 < n) {
                pq.add(new int[] {i, j + 1});
            }
        }
        return res;
    }
}
// @lc code=end

