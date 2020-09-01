/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = charFreq(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> s2Map = charFreq(s2.substring(i, i + s1.length()));
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> charFreq(String s) {
        Map<Character, Integer> res = new HashMap<>();
        for (char c : s.toCharArray()) {
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

