/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for (int i = 0; count < n; i++) {
            int cur = i;
            int pre = nums[cur];
            do {
                int next = (cur + k) % n;

                int t = nums[next];
                nums[next] = pre;
                pre = t;

                cur = next;
                count++;
            } while (i != cur);
        }
    }
}
// @lc code=end

