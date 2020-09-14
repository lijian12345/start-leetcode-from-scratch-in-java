/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int first = nums[i];
            flag = false;
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > first) {
                    res[i] = nums[j % n];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res[i] = -1;
            }
        }
        return res;
    }
}
// @lc code=end

