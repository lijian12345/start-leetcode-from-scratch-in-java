/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int lastOneStep = 1;
        int lastTwoSteps = 2;
        int res = 0;
        for (int i = 3; i < n + 1; i++) {
            res = lastOneStep + lastTwoSteps;
            lastOneStep = lastTwoSteps;
            lastTwoSteps = res;
        }
        return res;
    }
}
// @lc code=end

