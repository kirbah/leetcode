#
# @lc app=leetcode id=102 lang=python3
#
# [102] Binary Tree Level Order Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root:
            return result

        queue = collections.deque()
        queue.append(root)
        while queue:
            line = []

            for _ in range(len(queue)):
                node = queue.popleft()
                if node:
                    line.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if line:
                result.append(line)

        return result


# @lc code=end

