/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int bitmask = 0;
        for (String word : words) {
            bitmask = 0;
            for (char c : word.toCharArray()) {
                bitmask |= 1 << (c - 'a');
            }
            map.put(bitmask, Math.max(map.getOrDefault(bitmask, 0), word.length()));
        }

        int res = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    res = Math.max(res, map.get(x) * map.get(y));
                }
            }
        }
        return res;
    }
}
// @lc code=end

