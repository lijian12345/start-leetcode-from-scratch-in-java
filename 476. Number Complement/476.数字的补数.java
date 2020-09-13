/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum++;
            tmpNum >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);
    }
}
// @lc code=end

