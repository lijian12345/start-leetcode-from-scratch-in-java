/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int maxLevel = 1;
        TreeNode res = root;
        Queue<LevelNode> queue = new LinkedList<>();
        queue.offer(new LevelNode(root, 1));
        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.poll();
            TreeNode node = levelNode.node;
            int oldLevel = levelNode.level;
            if (oldLevel > maxLevel) {
                maxLevel = oldLevel;
                res = node;
            }
            if (node.left != null) {
                queue.offer(new LevelNode(node.left, oldLevel + 1));
            }
            if (node.right != null) {
                queue.offer(new LevelNode(node.right, oldLevel + 1));
            }
        }
        return res.val;
    }
}


class LevelNode {
    TreeNode node;
    int level;

    public LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
// @lc code=end

