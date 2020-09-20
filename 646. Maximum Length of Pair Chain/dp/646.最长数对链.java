/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0)
            return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
// @lc code=end

