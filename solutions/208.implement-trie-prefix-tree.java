/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start


class Trie {

    Node root;

    class Node {
        boolean isEndLetter = false;
        Node[] children = new Node[26];
        public Node() {}
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node();
            }
            current = current.children[c - 'a'];
        }
        current.isEndLetter = true;
    }
    
    public boolean search(String word) {
        Node node = lastNode(word);
        return node != null && node.isEndLetter;
    }

    public boolean startsWith(String prefix) {
        return lastNode(prefix) != null;
    }

    private Node lastNode(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return null;
            }
            current = current.children[c - 'a'];
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

