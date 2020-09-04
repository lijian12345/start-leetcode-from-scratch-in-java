/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] diffs = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            diffs[i] = A[i] - A[i - 1];
        }
        int res = 0;
        int count = 1;
        for (int i = 2; i < diffs.length; i++) {
            if (diffs[i] == diffs[i - 1]) {
                count++;
            } else {
                res += calcSum(count);
                count = 1;
            }
        }
        return res + calcSum(count);
    }

    private int calcSum(int count) {
        int n = count - 1;
        return (n + 1) * n / 2;
    }
}
// @lc code=end

