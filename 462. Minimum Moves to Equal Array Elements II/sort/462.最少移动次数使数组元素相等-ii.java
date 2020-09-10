/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int pivotIndex = partition(nums, l, r);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, l, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, r, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = i; j <= right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, right, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
// @lc code=end

