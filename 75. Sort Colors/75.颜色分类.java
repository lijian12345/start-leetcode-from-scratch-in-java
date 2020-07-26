/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        int p = 0;

        while (p <= j) {
            if (nums[p] == 0) {
                swap(nums, i, p);
                i++;
                p++;
            } else if (nums[p] == 2) {
                swap(nums, j, p);
                j--;
            } else {
                p++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
// @lc code=end

