/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int valley = 0;
        int res = 0;
        while (valley < prices.length) {
            int peak = valley + 1;
            while (peak < prices.length && prices[peak] > prices[peak - 1]) {
                peak++;
            }
            res += prices[peak - 1] - prices[valley];
            valley = peak;
        }
        return res;
    }
}
// @lc code=end

