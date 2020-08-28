/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, null);
    }

    private int helper(TreeNode root, TreeNode father) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, root);
        int right = helper(root.right, root);
        if (root.left == null && root.right == null) {
            if (father == null) {
                return 0;
            }
            if (father.left == root) {
                return left + right + root.val;
            }
        }
        return left + right;
    }
}
// @lc code=end

