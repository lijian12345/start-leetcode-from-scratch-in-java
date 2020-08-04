/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            p = p.next;
            lenA++;
        }
        while (q != null) {
            q = q.next;
            lenB++;
        }
        if (lenA * lenB == 0) {
            return null;
        }
        p = headA;
        q = headB;
        if (lenA > lenB) {
            int len = lenA - lenB;
            while (len > 0) {
                p = p.next;
                len--;
            }
        } else if (lenA < lenB) {
            int len = lenB - lenA;
            while (len > 0) {
                q = q.next;
                len--;
            }
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
// @lc code=end

