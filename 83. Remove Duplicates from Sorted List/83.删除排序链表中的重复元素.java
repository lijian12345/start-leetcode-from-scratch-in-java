/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            if (p.val == pre.val) {
                ListNode q = p.next;
                pre.next = q;
                p = q;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
// @lc code=end

