/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
// @lc code=end

