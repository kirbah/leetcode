#
# @lc app=leetcode id=143 lang=python3
#
# [143] Reorder List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next or not head.next.next:
            return
        
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next       # two steps

        cut_middle = slow
        slow = slow.next
        cut_middle.next = None      # This is the end of the new list

        tail = None                 # Reverse ordered second part of the list
        while slow:
            temp = slow.next
            slow.next = tail
            tail = slow
            slow = temp

        while head and tail:
            temp_head = head.next
            head.next = tail
            temp_tail = tail.next
            tail.next = temp_head
            head = head.next.next
            tail = temp_tail

# @lc code=end

