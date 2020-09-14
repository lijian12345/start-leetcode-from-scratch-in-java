/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                res = Math.max(res, j - i);
                i = j + 1;
            }
        }
        res = Math.max(res, nums.length - i);
        return res;
    }
}
// @lc code=end

