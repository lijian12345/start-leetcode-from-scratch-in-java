/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private Map<Character, String> m;

    public Solution() {
        m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        return backtrack(digits);
    }

    private List<String> backtrack(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        if (digits.length() == 1) {
            String tel = m.get(digits.charAt(0));
            for (int i = 0; i < tel.length(); i++) {
                res.add(tel.charAt(i) + "");
            }
            return res;
        }

        List<String> subRes = backtrack(digits.substring(1));
        String tel = m.get(digits.charAt(0));
        for (int i = 0; i < tel.length(); i++) {
            for (String s : subRes) {
                res.add(tel.charAt(i) + s);
            }
        }
        return res;
    }
}
// @lc code=end

