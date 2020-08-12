/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n];
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        leftToRight[0] = nums[0];
        rightToLeft[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftToRight[i] = leftToRight[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightToLeft[i] = rightToLeft[i + 1] * nums[i];
        }
        res[0] = rightToLeft[1];
        res[n - 1] = leftToRight[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = leftToRight[i - 1] * rightToLeft[i + 1];
        }
        return res;
    }
}
// @lc code=end

