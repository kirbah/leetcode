#
# @lc app=leetcode id=110 lang=python3
#
# [110] Balanced Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced = True

        def checkDepth(root):
            nonlocal balanced

            if not root:
                return 0

            left = checkDepth(root.left)
            right = checkDepth(root.right)
            balanced = balanced and abs(left - right) < 2

            return max(left, right) + 1

        checkDepth(root)
        return balanced
        
# @lc code=end

