/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int idx = stack.pop();

                    int pre = stack.isEmpty() ? 0 : stack.peek() + 1;
                    res = Math.max(res, (i - pre) * heights[idx]);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();

            int pre = stack.isEmpty() ? 0 : stack.peek() + 1;
            res = Math.max(res, (heights.length - pre) * heights[idx]);
        }
        return res;
    }
}
// @lc code=end

