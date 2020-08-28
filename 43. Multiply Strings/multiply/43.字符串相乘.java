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
        int m = num1.length(), n = num2.length();
        int[] resArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                resArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            resArr[i - 1] += resArr[i] / 10;
            resArr[i] %= 10;
        }
        int index = resArr[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        while (index < m + n) {
            res.append(resArr[index]);
            index++;
        }
        return res.toString();
    }
}
// @lc code=end

