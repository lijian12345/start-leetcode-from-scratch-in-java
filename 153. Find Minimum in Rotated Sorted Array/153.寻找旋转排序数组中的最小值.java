/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int res = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < res) {
                res = nums[mid];
            }
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
// @lc code=end

