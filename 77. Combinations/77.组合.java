/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new ArrayDeque<>());
        return res;
    }

    private void backtrack(int n, int k, int start, Deque<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n + 1; i++) {
            temp.add(i);
            backtrack(n, k - 1, i + 1, temp);
            temp.removeLast();
        }
    }
}
// @lc code=end

