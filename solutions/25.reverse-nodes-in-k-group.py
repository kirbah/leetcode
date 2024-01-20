#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        start = dummy
        end = head
        while end:
            i = 0
            while i < k and end:
                end = end.next
                i += 1
            if i == k:
                start = self.reverseNodes(start, end)
            else:
                break

        return dummy.next

    def reverseNodes(self, start: ListNode, end: ListNode) -> ListNode:
        next_start = start.next
        current = next_start
        prev = end
        while current != end:
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        start.next = prev
        return next_start


# @lc code=end

