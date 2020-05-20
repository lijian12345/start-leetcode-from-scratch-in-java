/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Integer> d = new ArrayDeque<>();
        while (x > 0) {
            d.add(x % 10);
            x /= 10;
        }
        while (d.size() > 1) {
            int left = d.pollFirst();
            int right = d.pollLast();
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

