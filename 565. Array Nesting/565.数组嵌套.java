/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 0;
            while (!set.contains(j)) {
                set.add(j);
                count++;
                j = nums[j];
            }
            if (count > res) {
                res = count;
            }
        }
        return res;
    }
}
// @lc code=end

