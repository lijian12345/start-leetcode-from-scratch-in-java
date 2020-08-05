/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            while (left < right && sum < target) {
                left++;
                sum = numbers[left] + numbers[right];
            }
            while (left < right && sum > target) {
                right--;
                sum = numbers[left] + numbers[right];
            }
        }
        return new int[] {left + 1, right + 1};
    }
}
// @lc code=end

