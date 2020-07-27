/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(0, new ArrayDeque<>());
        res.add(new ArrayList<>());
        return res;
    }

    private void backtrack(int i, Deque<Integer> path) {
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (i < j && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            res.add(new ArrayList<>(path));
            backtrack(j + 1, path);
            path.removeLast();
        }
    }
}
// @lc code=end

