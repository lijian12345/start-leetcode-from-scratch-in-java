/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map.get(num & 0xf));
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

