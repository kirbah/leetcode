/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class WordDictionary {

    Node root;
    class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        int maxLettersWord = 0;     // the longest word length. Set for first letter in first node after root.
    }

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
        int index = word.charAt(0) - 'a';
        root.children[index].maxLettersWord = Math.max(root.children[index].maxLettersWord, word.length());
        root.maxLettersWord = Math.max(root.maxLettersWord, word.length());
    }

    public boolean search(String word) {
        Node firstNode =  word.charAt(0) == '.' ? root : root.children[word.charAt(0) - 'a'];
        if (firstNode == null || firstNode.maxLettersWord < word.length()) {
            return false;
        }

        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int position, Node node) {
        if (word.length() == position) {
            return node.isEndOfWord;
        }

        char currentChar = word.charAt(position);
        if (currentChar != '.') {
            Node nextNode = node.children[currentChar - 'a'];
            return nextNode != null && dfs(word, position + 1, nextNode);
        }

        // Process all possible chars when there is '.' in the word
        for (int i = 0; i < 26; i++) {
            Node nextNode = node.children[i];
            if (nextNode != null && dfs(word, position + 1, nextNode)) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

