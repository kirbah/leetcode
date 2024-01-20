/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode blockStart = dummy;
        ListNode blockEnd = head;
        while (blockEnd != null) {
            int i = 0;
            while (i < k && blockEnd != null) {
                blockEnd = blockEnd.next;
                i++;
            }
            if (i == k) {
                blockStart = reverseBlock(blockStart, blockEnd);
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public ListNode reverseBlock(ListNode start, ListNode end) {
        ListNode current = start.next;
        ListNode previous = end;
        ListNode nextStart = current;
        while (current != end) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        start.next = previous;
        return nextStart;
    }
}
// @lc code=end

