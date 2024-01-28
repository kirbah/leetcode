#
# @lc app=leetcode id=230 lang=python3
#
# [230] Kth Smallest Element in a BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inOrderTraversal(node):
            if not node:
                return
            yield from inOrderTraversal(node.left)
            yield node.val
            yield from inOrderTraversal(node.right)

        gen = inOrderTraversal(root)
        for _ in range(k):
            result = next(gen)
        return result

    def kthSmallest_rec(self, root: Optional[TreeNode], k: int) -> int:
        result = []

        def process(node):
            nonlocal result
            if not node:
                return
            process(node.left)
            result.append(node.val)
            process(node.right)

        process(root)
        return result[k - 1]

    def kthSmallest_dfs(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        current = root
        while stack or current:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            k -= 1
            if k == 0:
                return current.val
            current = current.right

        
# @lc code=end

