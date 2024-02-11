#
# @lc app=leetcode id=133 lang=python3
#
# [133] Clone Graph
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:

    map = {}

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        if node in self.map:
            return self.map[node]

        cloned = Node(node.val, [])
        self.map[node] = cloned

        for neighbor in node.neighbors:
            cloned.neighbors.append(self.cloneGraph(neighbor))

        return cloned


# @lc code=end

