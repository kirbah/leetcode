#
# @lc app=leetcode id=104 lang=python3
#
# [104] Maximum Depth of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Deque


class Solution:
    # Recursive solution
    def maxDepth_rec(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    # Breadth-First Search (BFS) solution
    def maxDepth_bfs(self, root: Optional[TreeNode]) -> int:
        queue = Deque()
        if root:
            queue.append(root)
        depth = 0

        while queue:
            for i in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            depth += 1

        return depth

    # Iterative Depth-First Search (DFS)
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        stack = [[root, 1]]
        max_depth = 0

        while stack:
            node, depth = stack.pop()
            if node:
                max_depth = max(max_depth, depth)
                stack.append([node.right, depth + 1])
                stack.append([node.left, depth + 1])

        return max_depth

# @lc code=end

