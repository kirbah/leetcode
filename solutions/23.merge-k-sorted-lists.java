/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode[] result = lists;
        while (result.length > 1) {
            result = mergeList(result);
        }
        return result[0];
    }

    public ListNode[] mergeList(ListNode[] lists) {
        int n = lists.length;
        ListNode[] result = new ListNode[(n + 1) / 2];
        for (int i = 0; i < n; i += 2) {
            ListNode l1 = lists[i];
            ListNode l2 = i + 1 < n ? lists[i + 1] : null;
            result[i / 2] = mergeTwoLists(l1, l2);
        }
        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;

        ListNode result = new ListNode();   // Dummy first node
        ListNode current = result;
        while (l1 != null || l2 != null) {
            if ((l1 != null && l2 != null && l1.val <= l2.val) || (l1 != null && l2 == null)) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        return result.next;
    }
}
// @lc code=end

