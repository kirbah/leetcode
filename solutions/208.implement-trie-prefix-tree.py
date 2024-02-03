#
# @lc app=leetcode id=208 lang=python3
#
# [208] Implement Trie (Prefix Tree)
#

# @lc code=start
class Trie:

    class Node:
        def __init__(self):
            self.is_end_letter = False
            self.children = [None] * 26

    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        current = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not current.children[index]:
                current.children[index] = self.Node()
            current = current.children[index]
        current.is_end_letter = True

    def search(self, word: str) -> bool:
        last = self._find_last_node(word)
        return last and last.is_end_letter

    def startsWith(self, prefix: str) -> bool:
        return self._find_last_node(prefix)

    def _find_last_node(self, word: str) -> Optional[Node]:
        current = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not current.children[index]:
                return None
            current = current.children[index]
        return current

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

