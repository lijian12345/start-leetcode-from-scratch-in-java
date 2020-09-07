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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(matrix, i, j, m, n)) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private boolean bfs(int[][] matrix, int i, int j, int m, int n) {
        boolean isPacific = false;
        boolean isAtlantic = false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] d : directions) {
                int x = node.x + d[0], y = node.y + d[1];
                if (x == -1 || y == -1) {
                    isPacific = true;
                }
                if (x == m || y == n) {
                    isAtlantic = true;
                }
                if (isValid(matrix, m, n, node, x, y, visited)) {
                    queue.offer(new Node(x, y));
                    visited[x][y] = true;
                }
            }
        }
        return isPacific && isAtlantic;
    }

    private boolean isValid(int[][] matrix, int m, int n, Node node, int x, int y,
            boolean[][] visited) {
        return x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] <= matrix[node.x][node.y]
                && visited[x][y] == false;
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

