/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = charMap();
        Map<Character, Integer> s2Map = charMap();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i)) + 1);
            s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) + 1);
        }

        int count = 0;
        for (char c : s1Map.keySet()) {
            if (s1Map.get(c).equals(s2Map.get(c))) {
                count++;
            }
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) {
                return true;
            }
            char l = s2.charAt(i);
            char r = s2.charAt(i + s1.length());
            s2Map.put(r, s2Map.get(r) + 1);
            if (s2Map.get(r).equals(s1Map.get(r))) {
                count++;
            } else if (s2Map.get(r).equals(s1Map.get(r) + 1)) {
                count--;
            }
            s2Map.put(l, s2Map.get(l) - 1);
            if (s2Map.get(l).equals(s1Map.get(l))) {
                count++;
            } else if (s2Map.get(l).equals(s1Map.get(l) - 1)) {
                count--;
            }
        }
        return count == 26;
    }

    private Map<Character, Integer> charMap() {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 'a' + 0; i < 'a' + 26; i++) {
            res.put((char) i, 0);
        }
        return res;
    }
}
// @lc code=end

