/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        // up 存的是目前为止最长的上升摆动序列的长度(不要求以第 i 个元素结尾)
        // down 存的是目前为止最长的下降摆动序列的长度(不要求以第 i 个元素结尾)
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
// @lc code=end

