/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        this.s = s;
        backtrack(4, 0, new StringBuilder());
        return res;
    }

    private void backtrack(int nums, int start, StringBuilder sb) {
        // +3 means 3 '.'
        if (nums == 0 && sb.length() == s.length() + 3) {
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String code = s.substring(start, start + i);
            if (!isValidCode(code)) {
                continue;
            }
            if (nums == 1) {
                sb.append(code);
            } else {
                sb.append(code + ".");
            }
            backtrack(nums - 1, start + i, sb);
            if (nums == 1) {
                sb.delete(sb.length() - i, sb.length());
            } else {
                sb.delete(sb.length() - i - 1, sb.length());
            }
        }
    }

    private boolean isValidCode(String code) {
        if (code.equals("0")) {
            return true;
        }
        if (code.startsWith("0")) {
            return false;
        }
        int intCode = Integer.parseInt(code);
        return intCode >= 0 && intCode <= 255;
    }
}
// @lc code=end

