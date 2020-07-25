/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    // 使用long防止溢出
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left < right ? left : right);
    }
}
// @lc code=end

