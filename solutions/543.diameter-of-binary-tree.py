#
# @lc app=leetcode id=543 lang=python3
#
# [543] Diameter of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_2:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        max_diameter = 0

        def maxDepth(root):
            nonlocal max_diameter
            if not root:
                return 0

            left = maxDepth(root.left)
            right = maxDepth(root.right)
            max_diameter = max(max_diameter, left + right)

            return max(left, right) + 1

        maxDepth(root)
        return max_diameter

class Solution:
    max_diameter = 0

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        Solution.max_diameter = 0
        self.maxDepth(root)
        return Solution.max_diameter

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        max_left = self.maxDepth(root.left)
        max_right = self.maxDepth(root.right)
        Solution.max_diameter = max(Solution.max_diameter, max_left + max_right)

        return max(max_left, max_right) + 1

# @lc code=end

