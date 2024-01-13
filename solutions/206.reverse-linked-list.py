#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        res = None
        while head:
            temp = head.next
            head.next = res
            res = head
            head = temp

        return res

    def reverseList_v2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        res = None
        while head:
            res = ListNode(head.val, res)
            head = head.next
        return res

    def reverseList_req(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        return self.recursion(head.next, ListNode(head.val))

    def recursion(self, head: ListNode, next:ListNode) -> ListNode:
        if not head:
            return next
        return self.recursion(head.next, ListNode(head.val, next))
        
# @lc code=end

