/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode
 *     next; 
 *     ListNode(int x) { val = x; } 
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList;
        if (l1 == null) {
            if (l2 == null) {
                return null;
            } else {
                newList = l2;
                l2 = l2.next;
            }
        } else {
            if (l2 == null) {
                newList = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    newList = l1;
                    l1 = l1.next;
                } else {
                    newList = l2;
                    l2 = l2.next;
                }
            }
        }
        ListNode n = newList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                n.next = l1;
                n = n.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                n.next = l2;
                n = n.next;
                l2 = l2.next;
            } else {
                n.next = l1;
                n = n.next;
                l1 = l1.next;
                n.next = l2;
                l2 = l2.next;
                n = n.next;
            }
        }
        while (l1 != null) {
            n.next = l1;
            n = n.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            n.next = l2;
            n = n.next;
            l2 = l2.next;
        }
        return newList;
    }
}