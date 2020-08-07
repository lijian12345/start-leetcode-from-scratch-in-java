/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = maxHeap.poll();
        }
        return res;
    }
}
// @lc code=end

