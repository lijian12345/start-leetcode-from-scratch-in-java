/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
class Solution {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        calPath(root, sum);
        helper(root.left, sum);
        helper(root.right, sum);
    }

    private void calPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            res++;
        }
        calPath(root.left, sum - root.val);
        calPath(root.right, sum - root.val);
    }
}
// @lc code=end

