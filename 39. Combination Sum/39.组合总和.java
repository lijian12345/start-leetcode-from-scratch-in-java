/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> cur = new ArrayDeque<>();
        combine(candidates, 0, cur, target, res);
        return res;
    }

    private void combine(int[] candidates, int begin, Deque<Integer> cur, int target,
            List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            cur.add(candidates[i]);
            combine(candidates, i, cur, target - candidates[i], res);
            cur.removeLast();
        }
    }
}
// @lc code=end

