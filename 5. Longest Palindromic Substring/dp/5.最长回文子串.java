/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int[][] table = new int[len][len];
        // Iterate by length
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (i == 0) { // only one char
                    table[j][j + i] = 1;
                } else if (i == 1) { // two cahr
                    if (s.charAt(j) == s.charAt(j + i)) {
                        table[j][j + i] = 2;
                    }
                } else {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        if (table[j + 1][j + i - 1] != 0) {
                            table[j][j + i] = table[j + 1][j + i - 1] + 2;
                        }
                    }
                }
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (table[i][j] > table[x][y]) {
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
// @lc code=end

