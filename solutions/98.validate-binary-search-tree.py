#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValidSubtree(node, low_limit, high_limit):
            if not node:
                return True
            if not low_limit < node.val < high_limit:
                return False

            return isValidSubtree(node.left, low_limit, node.val) and isValidSubtree(node.right, node.val, high_limit)

        return isValidSubtree(root, float("-inf"), float("inf"))

# @lc code=end

