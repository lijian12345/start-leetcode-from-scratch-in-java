/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        s = s.trim();
        return cal(s.toCharArray());
    }

    private int cal(char[] chs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == chs.length - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
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

