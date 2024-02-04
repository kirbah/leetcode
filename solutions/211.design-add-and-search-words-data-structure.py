#
# @lc app=leetcode id=211 lang=python3
#
# [211] Design Add and Search Words Data Structure
#

# @lc code=start
class Node:
    def __init__(self):
        self.children = [None] * 26
        self.is_word_end = False
        self.word_max_length = 0

class WordDictionary:

    def __init__(self):
        self.root = Node()

    def addWord(self, word: str) -> None:
        node = self.root

        for c in word:
            index = ord(c) - ord('a')
            if not node.children[index]:
                node.children[index] = Node()
            node = node.children[index]

        node.is_word_end = True
        self.root.word_max_length = max(self.root.word_max_length, len(word))

    def search(self, word: str) -> bool:
        node_length = self.root
        if not node_length or node_length.word_max_length < len(word):
            return False

        def dfs(word, position, node):
            if position == len(word):
                return node.is_word_end

            current_char = word[position]
            if current_char != '.':
                next_node = node.children[ord(current_char) - ord('a')]
                return next_node and dfs(word, position + 1, next_node)

            # Process all possible chars when there is '.' in the word
            for i in range(26):
                next_node = node.children[i]
                if next_node and dfs(word, position + 1, next_node):
                    return True

            return False

        return dfs(word, 0, self.root)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
# @lc code=end

