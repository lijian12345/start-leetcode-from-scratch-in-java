class Solution {
    public int lengthOfLastWord(String s) {
        String[] afterSplit = s.split("\\s+");
        if (afterSplit.length > 0) {
            return afterSplit[afterSplit.length - 1].length();
        } else {
            return 0;
        }
    }
}