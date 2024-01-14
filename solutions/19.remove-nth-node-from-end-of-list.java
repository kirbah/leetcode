/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode delay = head;
        int i = 0;
        while (current != null) {
            current = current.next;
            if (i++ > n) {
                delay = delay.next;
            }
        }
        if (i == n) {
            return head.next;
        }
        if (delay.next != null) {
            delay.next = delay.next.next;
        }
        return head;
    }
}
// @lc code=end

