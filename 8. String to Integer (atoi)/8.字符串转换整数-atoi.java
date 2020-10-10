/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+')
            return 0;
        long res = 0l;
        boolean neg = s.charAt(0) == '-';
        int i = Character.isDigit(s.charAt(0)) ? 0 : 1;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i++) - '0');
            if (!neg && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (neg && res > 1L + Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return neg ? (int) -res : (int) res;
    }
}
// @lc code=end

