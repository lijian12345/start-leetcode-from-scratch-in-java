/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddList = new ListNode();
        ListNode evenList = new ListNode();
        ListNode p = head, po = oddList, pe = evenList;
        boolean isOdd = true;
        while (p != null) {
            if (isOdd) {
                po.next = p;
                po = po.next;
            } else {
                pe.next = p;
                pe = pe.next;
            }
            p = p.next;
            isOdd = !isOdd;
        }
        po.next = evenList.next;
        pe.next = null;
        return oddList.next;
    }
}
// @lc code=end

