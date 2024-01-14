/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode current = null;
        while (list1 != null || list2 != null) {
            ListNode next = null;
            if ((list1 != null && list2 != null && list1.val <= list2.val) || (list1 != null && list2 == null)) {
                next = list1;
                list1 = list1.next;
            } else {
                next = list2;
                list2 = list2.next;
            }
            if (res == null) {
                res = next;
                current = res;
            } else {
                current.next = next;
                current = next;
            }
        }
        return res;
    }
}
// @lc code=end

