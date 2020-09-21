/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        int p = path(root);
        if (p > res) {
            res = p;
        }
        helper(root.left);
        helper(root.right);
    }

    private int path(TreeNode root) {
        if (root == null)
            return 0;
        return siglePath(root.left, root.val) + siglePath(root.right, root.val);
    }

    private int siglePath(TreeNode root, int val) {
        if (root == null || root.val != val)
            return 0;
        return Math.max(siglePath(root.left, val), siglePath(root.right, val)) + 1;
    }
}
// @lc code=end

