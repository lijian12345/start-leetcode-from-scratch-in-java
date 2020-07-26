/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int zeroNum = 0, oneNum = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zeroNum++;
                    break;
                case 1:
                    oneNum++;
                    break;
            }
        }
        for (int i = 0; i < zeroNum; i++) {
            nums[i] = 0;
        }
        for (int i = zeroNum; i < zeroNum + oneNum; i++) {
            nums[i] = 1;
        }
        for (int i = zeroNum + oneNum; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
// @lc code=end

