#
# @lc app=leetcode id=100 lang=python3
#
# [100] Same Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if p and q and p.val == q.val:
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
        else:
            return False

    def isSameTree_dfs(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        stack = [[p, q]]
        while stack:
            node_p, node_q = stack.pop()

            if node_p and node_q:
                if node_p.val != node_q.val:
                    return False
                stack.append([node_p.left, node_q.left])
                stack.append([node_p.right, node_q.right])

            elif node_p or node_q:
                # One of the nodes is null, but not both
                return False

        return True

# @lc code=end

