/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s.isEmpty()) {
            return res;
        }
        if (isPalindrome(s)) {
            res.add(new LinkedList<>(Arrays.asList(s)));
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                for (List<String> part : partition(s.substring(i))) {
                    part.add(0, s.substring(0, i));
                    res.add(part);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

