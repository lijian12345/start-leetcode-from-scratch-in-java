/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    class Pair {
        ListNode head;
        ListNode tail;

        public Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public Pair reverse(ListNode head, ListNode tail) {
        ListNode p = head, q = p.next;
        while (q != tail) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        head.next = null;
        return new Pair(p, head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res, tail = head;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return res.next;
                }
                tail = tail.next;
            }
            Pair pair = reverse(head, tail);

            pre.next = pair.head;
            pair.tail.next = tail;
            pre = pair.tail;
            head = tail;
        }
        return res.next;
    }
}
// @lc code=end

