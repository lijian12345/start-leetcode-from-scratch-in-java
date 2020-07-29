/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private List<Integer> values;

    public Solution() {
        this.values = new ArrayList<Integer>();
    }

    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        this.mapListToValues(head);

        // Convert the array to
        return convertListToBST(0, this.values.size() - 1);
    }
}
// @lc code=end

