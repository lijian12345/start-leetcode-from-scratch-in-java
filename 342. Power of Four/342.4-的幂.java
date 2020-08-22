/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        // return num > 0 && Math.log(num) / Math.log(2) % 2 == 0;

        // return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;

        return num > 0 && (num & (num - 1)) == 0 && num % 3 == 1;
    }
}
// @lc code=end

