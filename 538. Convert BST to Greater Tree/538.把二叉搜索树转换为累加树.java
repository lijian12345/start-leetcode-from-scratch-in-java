/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    int sumFromRight = 0;

    public TreeNode convertBST(TreeNode root) {
        inOrderReverse(root);
        return root;
    }

    private void inOrderReverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderReverse(root.right);
        int t = sumFromRight;
        sumFromRight += root.val;
        root.val += t;
        inOrderReverse(root.left);
    }
}
// @lc code=end

