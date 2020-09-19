/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        int curDiameter = depthOfBinaryTree(root.left) + depthOfBinaryTree(root.right);
        if (curDiameter > res) {
            res = curDiameter;
        }
        helper(root.left);
        helper(root.right);
    }

    private int depthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthOfBinaryTree(root.left), depthOfBinaryTree(root.right)) + 1;
    }
}
// @lc code=end

