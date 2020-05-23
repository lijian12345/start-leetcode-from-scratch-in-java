/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int resDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            int minCloset = Integer.MAX_VALUE;
            int minDiff = Integer.MAX_VALUE;
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int twoSum = nums[j] + nums[k];
                int diff = Math.abs(twoSum - x);
                if (diff < minDiff) {
                    minDiff = diff;
                    minCloset = twoSum;
                }
                if (twoSum < x) {
                    j++;
                } else if (twoSum > x) {
                    k--;
                } else {
                    return target;
                }
            }
            if (minCloset == Integer.MAX_VALUE) {
                continue;
            }
            int thisMin = nums[i] + minCloset;
            int thisDiff = Math.abs(thisMin - target);
            if (thisDiff < resDiff) {
                resDiff = thisDiff;
                res = thisMin;
            }
        }
        return res;
    }
}
// @lc code=end

