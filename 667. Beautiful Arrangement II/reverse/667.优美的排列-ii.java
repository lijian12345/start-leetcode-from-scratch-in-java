/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        if (k == 1) {
            return res;
        }
        for (int i = 1; i < k; i++) {
            reverse(res, i, n - 1);
        }
        return res;
    }

    private void reverse(int[] res, int i, int j) {
        while (i < j) {
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
            i++;
            j--;
        }
    }
}
// @lc code=end

