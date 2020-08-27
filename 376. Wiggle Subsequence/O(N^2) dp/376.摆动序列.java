/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 首先，可以证明最长摆动序列一定可以以原始数组的第一个数作为开始。证明如下：若存在某个以第二个数为开始
        // 的摆动序列，这个摆动序列里的第二个数比第一个数大，而原始数组的第一个数比第二个数（也就是摆动序列的第
        // 一个数）大，则以原始数组的第一个数作为开始能使摆动序列长度+1；若摆动序列里的第二个数比第一个数大，
        // 而原始数组的第一个数比第二个数小，则选取原始数组的第一个数或者第二个数作为摆动序列的第一个数是等价
        // 的，不减少摆动序列长度。对于摆动序列中第二个数比第一个数小的情况对称可证。
        int n = nums.length;
        if (n == 0)
            return 0;
        // up[i] 存的是目前为止最长的以第 i 个元素结尾的上升摆动序列的长度。
        int[] up = new int[n];
        // down[i] 记录的是目前为止最长的以第 i 个元素结尾的下降摆动序列的长度。
        int[] down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
                if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
// @lc code=end

