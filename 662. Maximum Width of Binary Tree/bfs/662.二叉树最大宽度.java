/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, res = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode t = queue.poll();
            if (t.node != null) {
                queue.offer(new AnnotatedNode(t.node.left, t.depth + 1, t.pos * 2));
                queue.offer(new AnnotatedNode(t.node.right, t.depth + 1, t.pos * 2 + 1));
                if (curDepth != t.depth) {
                    curDepth = t.depth;
                    left = t.pos;
                }
                res = Math.max(res, t.pos - left + 1);
            }
        }
        return res;
    }
}


class AnnotatedNode {
    TreeNode node;
    int depth, pos;

    public AnnotatedNode(TreeNode node, int depth, int pos) {
        this.node = node;
        this.depth = depth;
        this.pos = pos;
    }
}

// @lc code=end

