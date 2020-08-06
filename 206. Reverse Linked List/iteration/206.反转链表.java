/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            ListNode q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        head.next = null;
        return pre;
    }
}
// @lc code=end

