/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            last.put(S.charAt(i), i);
        }

        int j = 0, anchor = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, last.get(S.charAt(i)));
            if (i == j) {
                res.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end

