/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int r = num + 1;
            while (set.contains(r)) {
                r++;
            }
            max = Math.max(max, r - num);
        }
        return max;
    }
}
// @lc code=end

