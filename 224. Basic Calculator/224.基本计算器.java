/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
    int i = 0;

    public int calculate(String s) {
        return cal(s.trim());
    }

    private int cal(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                i++;
                num = cal(s);
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                if (i == s.length() - 1) {
                    break;
                }
                sign = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
// @lc code=end

