/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        long l = 2, r = num / 2;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long x = mid * mid;
            if (x == num)
                return true;
            else if (x < num)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
// @lc code=end

