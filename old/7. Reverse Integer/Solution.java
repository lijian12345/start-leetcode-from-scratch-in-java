class Solution {
    public int reverse(int x) {
        String temp;
        if (x > 0) {
            temp = String.valueOf(x);
        } else if (x < 0) {
            temp = String.valueOf(-x);
        } else {
            return 0;
        }
        StringBuilder t = new StringBuilder(temp);
        t = t.reverse();
        int res;
        try {
            res = Integer.valueOf(t.toString());
        } catch (Exception e) {
            return 0;
        }

        if (x > 0)
            return res;
        else if (x < 0)
            return -res;
        return 0;
    }
}