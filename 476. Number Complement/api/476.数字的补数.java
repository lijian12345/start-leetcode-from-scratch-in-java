/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        String res = "";
        String binaryStr = Integer.toBinaryString(num);
        for (int i = 0; i < binaryStr.length(); i++) {
            res += binaryStr.charAt(i) ^ '1';
        }
        return Integer.parseInt(res, 2);
    }
}
// @lc code=end

