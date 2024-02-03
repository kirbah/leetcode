#
# @lc app=leetcode id=124 lang=python3
#
# [124] Binary Tree Maximum Path Sum
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = root.val if root else 0

        def maxPathSumHelper(node: TreeNode) -> int:
            nonlocal max_sum
            if not node:
                return 0

            left_sum = max(0, maxPathSumHelper(node.left))
            right_sum = max(0, maxPathSumHelper(node.right))

            max_sum = max(max_sum, left_sum + node.val + right_sum)
            return node.val + max(left_sum, right_sum)

        maxPathSumHelper(root)
        return max_sum

# @lc code=end

