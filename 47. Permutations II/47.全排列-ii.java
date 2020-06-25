/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> cur = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, cur, visited);
        return res;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> cur, boolean[] visited) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) {
                continue;
            }
            if (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) {
                continue;
            }
            cur.add(nums[j]);
            visited[j] = true;
            dfs(nums, depth + 1, cur, visited);
            visited[j] = false;
            cur.removeLast();
        }
    }
}
// @lc code=end

