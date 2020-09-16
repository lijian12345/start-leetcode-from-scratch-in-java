/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        return num >= 0 ? Integer.toString(num, 7) : "-" + Integer.toString(-num, 7);
    }
}
// @lc code=end

