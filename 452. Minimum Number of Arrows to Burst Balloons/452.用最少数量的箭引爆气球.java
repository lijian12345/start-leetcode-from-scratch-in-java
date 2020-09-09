/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int res = 1;
        int xEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > xEnd) {
                res++;
                xEnd = points[i][1];
            }
        }
        return res;
    }
}
// @lc code=end

