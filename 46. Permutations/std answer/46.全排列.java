/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for (int num : nums) {
            out.add(num);
        }
        backtrack(nums.length, out, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> out, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(out, first, i);
            backtrack(n, out, res, first + 1);
            Collections.swap(out, first, i);
        }
    }
}
// @lc code=end

