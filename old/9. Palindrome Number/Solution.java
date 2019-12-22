class Solution {
    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        StringBuilder t = new StringBuilder(temp);
        t.reverse();

        if (temp.equals(t.toString())) {
            return true;
        } else {
            return false;
        }

    }
}