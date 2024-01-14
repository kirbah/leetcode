#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        res = None
        current = None

        while list1 and list2:
            if list1 and list2 and list1.val <= list2.val:
                next_node = list1
                list1 = list1.next
            else:
                next_node = list2
                list2 = list2.next

            if not res:
                res = current = next_node
            else:
                current.next = next_node
                current = current.next

        if not res:
            res = list1 or list2
        else:
            current.next = list1 or list2

        return res
        
# @lc code=end

