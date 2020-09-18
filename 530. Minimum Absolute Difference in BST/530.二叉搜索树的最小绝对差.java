/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    int res = Integer.MAX_VALUE;
    Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre == null) {
            pre = root.val;
        } else {
            if (root.val - pre < res) {
                res = root.val - pre;
            }
            pre = root.val;
        }
        inOrder(root.right);
    }
}
// @lc code=end

