#
# @lc app=leetcode id=23 lang=python3
#
# [23] Merge k Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        result = lists
        while len(result) > 1:
            result = self.mergeLists(result)

        return result[0]

    def mergeLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        n = len(lists)
        result = []
        for i in range(0, n, 2):
            l1 = lists[i]
            l2 = lists[i + 1] if i + 1 < n else None
            result.append(self.mergeTwoLists(l1, l2))

        return result

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l2:
            return l1

        dummy = ListNode()
        current = dummy
        while l1 and l2:
            if l1 and l2 and l1.val <= l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next
            current = current.next

        current.next = l1 or l2

        return dummy.next

# @lc code=end

