/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - 1 - low) % 2 == 1) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((mid - low) % 2 == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[low];
    }
}
// @lc code=end

