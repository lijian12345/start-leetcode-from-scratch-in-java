import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(target - nums[i])) {
                m.put(nums[i], i);
            } else {
                return new int[] { m.get(target - nums[i]), i };
            }
        }
        return new int[] { 0, 1 };
    }
}
// @lc code=end
