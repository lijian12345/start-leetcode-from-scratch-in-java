/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(charArray[i])) {
                i++;
            }
            while (i < j && !isVowel(charArray[j])) {
                j--;
            }
            if (i < j) {
                swap(charArray, i, j);
                i++;
                j--;
            }
        }
        return new String(charArray);
    }

    private void swap(char[] charArray, int i, int j) {
        char t = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = t;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end

