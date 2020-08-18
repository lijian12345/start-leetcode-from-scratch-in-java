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
    int res;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        res = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.computeIfAbsent(depth, x -> pos);
        res = Math.max(res, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }
}
// @lc code=end

