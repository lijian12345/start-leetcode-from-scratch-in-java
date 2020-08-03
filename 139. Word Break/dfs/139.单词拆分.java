/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    String s;
    List<String> wordDict;
    boolean[] visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.visited = new boolean[s.length() + 1];
        return dfs(0);
    }

    private boolean dfs(int start) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {
                if (nextStart == s.length() || dfs(nextStart)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        return false;
    }
}
// @lc code=end

