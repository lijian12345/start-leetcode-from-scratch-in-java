/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int target, int left, int right) {
        int index = partition(nums, left, right);
        if (index == target) {
            return nums[index];
        } else if (index > target) {
            return quickSelect(nums, target, left, index - 1);
        } else {
            return quickSelect(nums, target, index + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomI = random.nextInt(right - left + 1) + left;
        swap(nums, randomI, right);
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
// @lc code=end

