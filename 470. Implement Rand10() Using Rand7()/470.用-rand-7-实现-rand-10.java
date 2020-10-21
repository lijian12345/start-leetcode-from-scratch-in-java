/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7; // 1 ~ 49
            if (idx <= 40) {
                return idx % 10 + 1;
            }
            a = idx - 40;   // 1 ~ 9
            b = rand7();
            idx = b + (a - 1) * 7; // 1 ~ 63
            if (idx <= 60) {
                return idx % 10 + 1;
            }
            a = idx - 60;   // 1 ~ 3
            b = rand7();
            idx = b + (a - 1) * 7; // 1 ~ 21
            if (idx <= 20) {
                return idx % 10 + 1;
            }
        }
    }
}
// @lc code=end

