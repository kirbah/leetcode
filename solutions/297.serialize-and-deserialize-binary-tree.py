#
# @lc app=leetcode id=297 lang=python3
#
# [297] Serialize and Deserialize Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    NULL = "N"
    DELIMITER = ","

    def serialize(self, root):
        result = []

        def dfs(node):
            if not node:
                result.append(self.NULL)
                return
            
            result.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return self.DELIMITER.join(result)

    def deserialize(self, data):
        tokes = data.split(self.DELIMITER)
        index = 0

        def dfs():
            nonlocal index
            token = tokes[index]
            index += 1
            if self.NULL == token:
                return None

            node = TreeNode(int(token))
            node.left = dfs()
            node.right = dfs()
            return node

        return dfs()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
# @lc code=end

