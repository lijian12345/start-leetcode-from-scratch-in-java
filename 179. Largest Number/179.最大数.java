/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(i -> String.valueOf(i))
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).reduce((s1, s2) -> {
                    if ("0".equals(s1)) {
                        s1 = "";
                    }
                    return s1 + s2;
                }).orElse("0");
    }
}
// @lc code=end

