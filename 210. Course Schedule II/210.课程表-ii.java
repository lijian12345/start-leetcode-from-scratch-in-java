/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] visited;//标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    boolean valid = true;//判断有向图中是否有环，true表示没有
    Deque<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        stack = new ArrayDeque<>();
        for (int[] nodes : prerequisites) {
            edges.get(nodes[1]).add(nodes[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {// 有环
            return new int[0];
        }
        int num = stack.size();
        int[] res = new int[num];

        for (int i = 0; i < num; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        stack.push(u);
    }
}
// @lc code=end

