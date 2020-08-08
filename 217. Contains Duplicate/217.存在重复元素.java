/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (!set.add(a)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

