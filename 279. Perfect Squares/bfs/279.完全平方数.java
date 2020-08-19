/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> nextQueue = new HashSet<>();

            for (int remainder : queue) {
                for (int square : squares) {
                    if (remainder == square) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        nextQueue.add(remainder - square);
                    }
                }
            }
            queue = nextQueue;
        }
        return level;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        return squares;
    }
}
// @lc code=end

