/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        } else if (b.equals("0")) {
            return a;
        }
        StringBuilder res = new StringBuilder();
        int m = a.length(), n = b.length();
        int carry = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            int t;
            if (i < 0) {
                t = b.charAt(j) - '0' + carry;
            } else if (j < 0) {
                t = a.charAt(i) - '0' + carry;
            } else {
                t = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            }
            res.append(String.valueOf(t % 2));
            carry = t / 2;
            i--;
            j--;
        }
        if (carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }
}
// @lc code=end
