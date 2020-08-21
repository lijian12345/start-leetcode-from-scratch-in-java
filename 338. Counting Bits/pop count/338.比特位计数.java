/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = popcount(i);
        }
        return res;
    }

    private int popcount(int x) {
        int res = 0;
        while (x > 0) {
            x &= x - 1;
            res++;
        }
        return res;
    }
}
// @lc code=end

