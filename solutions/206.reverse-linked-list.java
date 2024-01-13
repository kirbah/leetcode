/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }

    public ListNode reverseList_v2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = null;
        while (head != null) {
            res = new ListNode(head.val, res);
            head = head.next;
        }
        return res;
    }

    public ListNode reverseList_req(ListNode head) {
        if (head == null || head.next == null) return head;
        return recursion(head.next, new ListNode(head.val));
    }

    public ListNode recursion(ListNode head, ListNode next) {
        if (head == null) return next;
        return recursion(head.next, new ListNode(head.val, next));
    }
}
// @lc code=end

