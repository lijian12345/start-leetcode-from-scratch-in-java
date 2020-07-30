/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
// @lc code=end

