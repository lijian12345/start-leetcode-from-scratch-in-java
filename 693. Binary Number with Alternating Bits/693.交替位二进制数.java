/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        int m = ((n >> 1) ^ n);
        return (m & (m + 1)) == 0;
    }
}
// @lc code=end

