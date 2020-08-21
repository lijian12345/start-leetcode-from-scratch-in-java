/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                res[i + b] = res[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return res;
    }
}
// @lc code=end

