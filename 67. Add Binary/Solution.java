class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                if (!flag)
                    res.append(1);
                else {
                    res.append(0);
                    flag = true;
                }
            } else {
                if (a.charAt(i) == '0') {
                    if (!flag) {
                        res.append(0);
                    } else {
                        res.append(1);
                        flag = false;
                    }
                } else {
                    if (!flag) {
                        res.append(0);
                        flag = true;
                    } else {
                        res.append(1);
                        flag = true;
                    }
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (a.charAt(i) == '0') {
                if (!flag) {
                    res.append(0);
                } else {
                    res.append(1);
                    flag = false;
                }
            } else {
                if (!flag) {
                    res.append(1);
                } else {
                    res.append(0);
                    flag = true;
                }
            }
            i--;
        }
        while (j >= 0) {
            if (b.charAt(j) == '0') {
                if (!flag) {
                    res.append(0);
                } else {
                    res.append(1);
                    flag = false;
                }
            } else {
                if (!flag) {
                    res.append(1);
                } else {
                    res.append(0);
                    flag = true;
                }
            }
            j--;
        }
        if (flag) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}