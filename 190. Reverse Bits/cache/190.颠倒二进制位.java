/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret |= reverseByte((byte) (n & 0b11111111));
            n >>= 8;
        }
        return ret;
    }

    private int reverseByte(byte b) {
        if (cache.containsKey(b))
            return cache.get(b);
        int ret = 0;
        byte t = b;
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= t & 1;
            t >>= 1;
        }
        cache.put(b, ret);
        return ret;
    }

}
// @lc code=end

