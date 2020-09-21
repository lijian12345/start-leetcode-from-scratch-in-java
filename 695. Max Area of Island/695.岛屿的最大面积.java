/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
public class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j, m, n);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] g, int i, int j, int m, int n) {
        int area = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        g[i][j] = 2;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int[] d : directions) {
                int x = node.x + d[0], y = node.y + d[1];
                if (isValid(x, y, m, n, g)) {
                    q.add(new Node(x, y));
                    g[x][y] = 2;
                    area++;
                }
            }
        }
        return area;
    }

    private boolean isValid(int x, int y, int m, int n, int[][] g) {
        return x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 1;
    }
}


class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// @lc code=end

