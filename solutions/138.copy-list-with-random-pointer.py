#
# @lc app=leetcode id=138 lang=python3
#
# [138] Copy List with Random Pointer
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        # Creat copies in map
        map = {None: None}
        current = head
        while current:
            map[current] = Node(current.val)
            current = current.next

        # Update pointers to copied nodes
        current = head
        while current:
            map[current].next = map[current.next]
            map[current].random = map[current.random]
            current = current.next

        return map[head]


    def copyRandomList_without_hashmap(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        current = head
        # Insert copy of each node on the 2x places inside initial list
        while current:
            copy = Node(current.val, current.next)
            current.next = copy
            current = copy.next
        res = head.next

        # Point random in final list to copies located on 2nd places
        current = head
        while current and current.next:
            current.next.random = current.random.next if current.random else None
            current = current.next.next

        # Restore the original list pointers 
        # and set proper next pointer in the new list
        current = head
        while current and current.next:
            next_original = current.next.next
            copy_node = current.next
            copy_node.next = next_original.next if next_original else None
            current.next = next_original
            current = next_original

        return res
        
# @lc code=end

