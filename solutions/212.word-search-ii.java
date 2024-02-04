/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    class Node{
        Node[] children = new Node[26];
        int references = 0;     // How many words use this node (have this charecter)
        String word;            // Final node stores entire word

        void addWord(String word) {
            Node currentNode = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new Node();
                }
                currentNode = currentNode.children[index];
                currentNode.references++;
            }
            currentNode.word = word;
        }
        void removeWord(String word) {
            Node currentNode = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                currentNode = currentNode.children[index];
                currentNode.references--;
            }
            currentNode.word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            root.addWord(word);
        }

        List<String> foundWords = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, root, foundWords);
                if (foundWords.size() == words.length) {
                    return foundWords;
                }
            }
        }

        return foundWords;
    }

    private void dfs(char[][] board, int row, int col, Node node, Node root, List<String> foundWords) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return;
        }
        Node nextNode = node.children[board[row][col] - 'a'];
        if (nextNode == null || nextNode.references < 1) {
            return;
        }
        if (nextNode.word != null) {
            foundWords.add(nextNode.word);
            root.removeWord(nextNode.word);
        }

        char oldValueAtPosition = board[row][col];
        board[row][col] = '#';  // Mark visitied cell to prevent second pass over it

        dfs(board, row + 1, col, nextNode, root, foundWords);
        dfs(board, row - 1, col, nextNode, root, foundWords);
        dfs(board, row, col + 1, nextNode, root, foundWords);
        dfs(board, row, col - 1, nextNode, root, foundWords);

        board[row][col] = oldValueAtPosition;
    }
}
// @lc code=end

