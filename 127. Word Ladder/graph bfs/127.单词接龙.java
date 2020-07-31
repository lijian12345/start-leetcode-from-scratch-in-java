/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    class Node {
        String word;
        List<Node> children;
        boolean isVisited;
        int level;

        public Node(String word) {
            this.word = word;
            this.children = new LinkedList<>();
            this.isVisited = false;
            this.level = 0;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Node graph = setUpGraph(beginWord, wordList);
        Queue<Node> queue = new LinkedList<>();
        queue.add(graph);
        graph.isVisited = true;
        Node res = graph;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.word.equals(endWord)) {
                res = node;
                break;
            }
            for (Node child : node.children) {
                if (child.isVisited == false) {
                    queue.add(child);
                    child.isVisited = true;
                    child.level = node.level + 1;
                }
            }
        }
        return res == graph ? 0 : res.level + 1;
    }

    private Node setUpGraph(String beginWord, List<String> wordList) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(beginWord));
        for (String word : wordList) {
            nodes.add(new Node(word));
        }
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if (isNextWord(nodes.get(i).word, nodes.get(j).word)) {
                    nodes.get(i).children.add(nodes.get(j));
                }
            }
        }
        return nodes.get(0);
    }

    private boolean isNextWord(String beginWord, String word) {
        int sum = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }
}
// @lc code=end

