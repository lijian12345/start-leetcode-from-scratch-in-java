/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> copyList = new ArrayList<>();
            for (List<Integer> t : res) {
                copyList.add(new ArrayList<>(t));
                t.add(num);
            }
            res.addAll(copyList);
        }
        return res;
    }
}
// @lc code=end

