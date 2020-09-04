/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[target]) {
                return true;
            }
            int v = nums[i];
            for (int j = target; j >= 1; j--) {
                if (j >= v) {
                    dp[j] = dp[j] || dp[j - v];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

