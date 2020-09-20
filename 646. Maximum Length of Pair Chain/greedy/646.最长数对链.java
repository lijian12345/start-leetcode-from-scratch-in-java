/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0)
            return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1;
        int recentEnd = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > recentEnd) {
                res++;
                recentEnd = pairs[i][1];
            }
        }
        return res;
    }
}
// @lc code=end

