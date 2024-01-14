#
# @lc app=leetcode id=19 lang=python3
#
# [19] Remove Nth Node From End of List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        current = head
        delayed = head
        i = 0
        while current:
            current = current.next
            if i > n:
                delayed = delayed.next
            i += 1

        if i == n:
            return head.next

        if delayed.next:
            delayed.next = delayed.next.next

        return head
        
# @lc code=end

