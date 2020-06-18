/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode r = res, p = head, q = head.next;
        ListNode t = q.next;
        while (t != null && t.next != null) {
            r.next = q;
            q.next = p;
            p.next = t;
            r = p;
            p = t;
            q = p.next;
            t = q.next;
        }

        r.next = q;
        q.next = p;
        p.next = t;

        return res.next;
    }
}
// @lc code=end

