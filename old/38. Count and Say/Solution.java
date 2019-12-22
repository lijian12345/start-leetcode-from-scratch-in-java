class Solution {
    public String countAndSay(int n) {
        StringBuilder[] str = new StringBuilder[30];
        for (int i = 0; i < 30; i++) {
            str[i] = new StringBuilder();
        }
        str[0].append("1");
        for (int i = 1; i < 30; i++) {
            String tmpStr = str[i - 1].toString();
            Deque<Character> q = new ArrayDeque<>();
            for (int j = 0; j < tmpStr.length(); j++)
                q.add(tmpStr.charAt(j));
            while (!q.isEmpty()) {
                Character t = q.poll();
                int num = 1;
                while (q.peek() == t) {
                    num++;
                    q.remove();
                }
                str[i].append(num);
                str[i].append(t);
            }
        }
        return str[n - 1].toString();
    }
}