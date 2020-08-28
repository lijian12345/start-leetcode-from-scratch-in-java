/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = n1 * n2 + carry;
                sb.append(product % 10);
                carry = product / 10;
            }
            res = addStrings(res, sb);
        }
        return res.reverse().toString();
    }

    private StringBuilder addStrings(StringBuilder s1, StringBuilder s2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0, j = 0; i < s1.length() || j < s2.length() || carry != 0; i++, j++) {
            int n1 = i >= s1.length() ? 0 : s1.charAt(i) - '0';
            int n2 = j >= s2.length() ? 0 : s2.charAt(j) - '0';
            int sum = n1 + n2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res;
    }
}
// @lc code=end

