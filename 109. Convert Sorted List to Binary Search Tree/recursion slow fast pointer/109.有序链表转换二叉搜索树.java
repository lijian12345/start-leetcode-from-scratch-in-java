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
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) { // 左闭右开
        if (head == tail) {
            return null;
        }
        if (head.next == tail) {
            return new TreeNode(head.val);
        }
        ListNode slowPointer = findMid(head, tail);
        TreeNode root = new TreeNode(slowPointer.val);
        root.left = helper(head, slowPointer);
        root.right = helper(slowPointer.next, tail);
        return root;
    }

    private ListNode findMid(ListNode head, ListNode tail) {
        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer != tail && fastPointer.next != tail) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
// @lc code=end

