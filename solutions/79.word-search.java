/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int position) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
           || word.charAt(position) != board[row][col]) {
            return false;
        }
        if (position == word.length() - 1) {
            return true;
        }

        char oldValueAtPosition = board[row][col];
        board[row][col] = '#';  // Mark visitied cell to prevent second pass over it

        int nextPosition = position + 1;
        boolean isExists = dfs(board, word, row + 1, col, nextPosition)
                         ||dfs(board, word, row - 1, col, nextPosition)
                         ||dfs(board, word, row, col + 1, nextPosition)
                         ||dfs(board, word, row, col - 1, nextPosition);

        board[row][col] = oldValueAtPosition;
        return isExists;
    }
}
// @lc code=end

