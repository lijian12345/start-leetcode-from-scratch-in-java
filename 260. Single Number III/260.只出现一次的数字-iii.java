/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);

        int x = 0;
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[] {x, bitmask ^ x};
    }
}
// @lc code=end

