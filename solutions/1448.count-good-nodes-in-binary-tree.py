#
# @lc app=leetcode id=1448 lang=python3
#
# [1448] Count Good Nodes in Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        good_nodes = 0

        def checkNodes(node, maximum):
            nonlocal good_nodes
            if not node:
                return

            if node.val >= maximum:
                good_nodes += 1

            maximum = max(maximum, node.val)
            checkNodes(node.left, maximum)
            checkNodes(node.right, maximum)

        checkNodes(root, root.val)
        return good_nodes

# @lc code=end

