/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        return list2Array(maxCntNums);
    }

    private int[] list2Array(List<Integer> maxCntNums) {
        int[] res = new int[maxCntNums.size()];
        int i = 0;
        for (int num : maxCntNums) {
            res[i++] = num;
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        if (pre != null) {
            if (pre.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(root.val);
        } else if (curCnt == maxCnt) {
            nums.add(root.val);
        }
        pre = root;
        inOrder(root.right, nums);
    }
}
// @lc code=end

