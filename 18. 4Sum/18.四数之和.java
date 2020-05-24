/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int jTarget = target - nums[i] - nums[j];
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    int twoSum = nums[k] + nums[l];
                    if (twoSum < jTarget) {
                        k++;
                    } else if (twoSum > jTarget) {
                        l--;
                    } else {
                        List<Integer> lst = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        res.add(lst);
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

