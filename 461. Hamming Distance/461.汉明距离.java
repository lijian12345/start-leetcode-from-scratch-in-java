/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        while (xor != 0) {
            xor &= (xor - 1);
            res++;
        }
        return res;
    }
}
// @lc code=end

