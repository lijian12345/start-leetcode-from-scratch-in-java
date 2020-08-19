/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
// @lc code=end

