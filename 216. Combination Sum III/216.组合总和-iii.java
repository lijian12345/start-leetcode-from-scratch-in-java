/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayDeque<>());
        return res;
    }

    private void dfs(int k, int n, int start, Deque<Integer> deque) {
        if (k == 0) {
            if (n == 0)
                res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < 10; i++) {
            deque.add(i);
            dfs(k - 1, n - i, i + 1, deque);
            deque.removeLast();
        }
    }
}
// @lc code=end

