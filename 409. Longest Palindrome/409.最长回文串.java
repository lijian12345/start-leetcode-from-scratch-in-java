/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        boolean hasOdd = false;
        for (char c : map.keySet()) {
            int num = map.get(c);
            if (num % 2 == 1) {
                hasOdd = true;
                res += num - 1;
            } else {
                res += num;
            }
        }
        return hasOdd ? res + 1 : res;
    }
}
// @lc code=end

