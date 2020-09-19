/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int vaildNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (isValid(flowerbed, i)) {
                vaildNum++;
                flowerbed[i] = 1;
            }
            if (vaildNum >= n) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[] flowerbed, int i) {
        return flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
    }
}
// @lc code=end

