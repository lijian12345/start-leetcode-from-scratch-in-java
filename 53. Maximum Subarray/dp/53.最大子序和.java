/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums.length == 0) {
            return res;
        }
        int preMax = nums[0];
        res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            if (preMax > res) {
                res = preMax;
            }
        }
        return res;
    }
}
// @lc code=end

