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
        // res[i] 表示索引 i 左侧所有元素的乘积
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // R 为右侧所有元素的乘积
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }
}
// @lc code=end

