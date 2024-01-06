/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Character>[] columnsCheck = new Set[n];
        for (int i=0; i<n; i++) {
            columnsCheck[i] = new HashSet<>();
        }
        Set<Character>[][] blockCheck = new Set[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                blockCheck[i][j] = new HashSet<>();
            }
        }

        for (int row=0; row<n; row++) {
            Set<Character> rowCheck = new HashSet<>();
            for (int col=0; col<n; col++) {
                char current = board[row][col];
                if (current != '.') {
                    if (!columnsCheck[col].add(current)) {
                        return false; // duplicate found
                    }
                    if (!rowCheck.add(current)) {
                        return false;
                    }
                    if (!blockCheck[row/3][col/3].add(current)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

