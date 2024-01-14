/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;   // it will point to the middle once fast reach the end
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;   // do two steps
        }

        ListNode cutMiddle = slow;
        slow = slow.next;
        cutMiddle.next = null;    // There will be the end of the reordered list

        ListNode tail = null;   // it will contain second part of list in the reverse order
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = tail;
            tail = slow;
            slow = temp;
        }

        while (head != null && tail != null) {
            ListNode tempHead = head.next;
            head.next = tail;
            ListNode tempTail = tail.next;
            tail.next = tempHead;
            tail = tempTail;
            head = head.next.next;
        }
    }
}
// @lc code=end

