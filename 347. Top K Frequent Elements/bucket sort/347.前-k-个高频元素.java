/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (buckets[i] == null) {
                buckets[i] = new ArrayList<>();
            }
            buckets[i].add(key);
        }
        int[] res = new int[k];
        int i = k - 1;
        for (int j = buckets.length - 1; j >= 0 && i >= 0; j--) {
            if (buckets[j] == null)
                continue;
            for (int n : buckets[j]) {
                if (i >= 0) {
                    res[i--] = n;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

