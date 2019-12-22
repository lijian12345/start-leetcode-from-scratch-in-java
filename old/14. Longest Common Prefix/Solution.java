class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder commonPrefix = new StringBuilder("");
        int minLen = strs[0].length();
        for (String i : strs) {
            int len = i.length();
            if (len < minLen) {
                minLen = len;
            }
        }
        int strLen = strs.length;
        loop:
        for (int i = 0; i < minLen; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strLen; j++) {
                if (strs[j].charAt(i) != temp) {
                    break loop;
                }
            }
            commonPrefix.append(temp);
        }
        return commonPrefix.toString();
    }
}