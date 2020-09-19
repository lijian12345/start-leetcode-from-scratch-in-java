/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum > c) {
                r--;
            } else if (sum < c) {
                l++;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

