#
# @lc app=leetcode id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        def subTree(preorder_index, inorder_start, inorder_end) -> TreeNode:
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)
            inorder_index = inorder_map[root_value]

            if inorder_index > inorder_start:
                # Next node from preorder[] is the next root for the left subtree
                root.left = subTree(preorder_index + 1, inorder_start, inorder_index - 1)
            if inorder_index < inorder_end:
                # inorder_index - inorder_start = number of nodes that will be used to build the left part of the tree
                # the next node from preorder[] will be the next root to start the right part of the tree
                root.right = subTree(preorder_index + (inorder_index - inorder_start) + 1, inorder_index + 1, inorder_end)
            return root

        return subTree(0, 0, len(preorder) - 1)

# @lc code=end

