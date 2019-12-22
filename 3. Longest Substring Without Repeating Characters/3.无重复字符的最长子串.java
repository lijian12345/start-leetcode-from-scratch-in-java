import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                start = Math.max(m.get(s.charAt(i)) + 1, start);
            }
            res = Math.max(res, i - start + 1);
            m.put(s.charAt(i), i);
        }
        return res;
    }
}
// @lc code=end
