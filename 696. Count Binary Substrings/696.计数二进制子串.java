/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                count++;
            }
            counts.add(count);
        }
        int res = 0;
        for (int j = 1; j < counts.size(); j++) {
            res += Math.min(counts.get(j), counts.get(j - 1));
        }
        return res;
    }
}
// @lc code=end

