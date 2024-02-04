#
# @lc app=leetcode id=212 lang=python3
#
# [212] Word Search II
#

# @lc code=start

class Node:
    def __init__(self):
        self.children = [None] * 26
        self.word = None        # Final node stores entire word
        self.references = 0     # How many words use this node (have this charecter)

    def addWord(self, word):
        node = self
        for char in word:
            index = ord(char) - ord('a')
            if not node.children[index]:
                node.children[index] = Node()
            node = node.children[index]
            node.references += 1
        node.word = word

    def removeWord(self, word):
        node = self
        for char in word:
            index = ord(char) - ord('a')
            node = node.children[index]
            node.references -= 1
        node.word = None

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        rows, cols = len(board), len(board[0])
        found_words = []
        root = Node()
        for word in words:
            root.addWord(word)

        def dfs(row, col, node):
            if row < 0 or col < 0 or row >= rows or col >= cols or board[row][col] == '#':
                return
            next_node = node.children[ord(board[row][col]) - ord('a')]
            if not next_node or next_node.references < 1:
                return
            if next_node.word:
                found_words.append(next_node.word)
                root.removeWord(next_node.word)

            old_value_at_position = board[row][col]
            board[row][col] = '#'

            dfs(row + 1, col, next_node)
            dfs(row - 1, col, next_node)
            dfs(row, col + 1, next_node)
            dfs(row, col - 1, next_node)

            board[row][col] = old_value_at_position
            return

        for row in range(rows):
            for col in range(cols):
                dfs(row, col, root)
                if len(found_words) == len(words):
                    return found_words

        return found_words

# @lc code=end

