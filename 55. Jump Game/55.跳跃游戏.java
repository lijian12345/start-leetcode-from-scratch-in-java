/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int maxReachable = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxReachable && i + nums[i] > maxReachable) {
                maxReachable = i + nums[i];
            }
        }
        return maxReachable >= nums.length - 1 ? true : false;
    }
}
// @lc code=end

