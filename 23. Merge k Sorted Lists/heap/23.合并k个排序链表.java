/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public static class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
        ListNode res = new ListNode(0);
        ListNode p = res;
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode minElement = pq.poll();
            p.next = minElement;
            p = p.next;
            if (minElement.next != null) {
                pq.add(minElement.next);
            }
        }
        return res.next;
    }
}
// @lc code=end

