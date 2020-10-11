/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    // 数组头尾各添一个 0
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                res = Math.max(res, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

