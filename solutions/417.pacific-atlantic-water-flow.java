/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] seenP = new boolean[rows][cols];
        boolean[][] seenA = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights[row][0], heights, seenP);
            dfs(row, cols - 1, heights[row][cols - 1], heights, seenA);
        }

        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights[0][col], heights, seenP);
            dfs(rows - 1, col, heights[rows - 1][col], heights, seenA);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (seenP[row][col] && seenA[row][col]) {
                    result.add(new ArrayList<>(Arrays.asList(row, col)));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int height, int[][] heights, boolean[][] seen) {
        if (row >= 0 && row < heights.length && col >= 0 && col < heights[0].length
         && !seen[row][col] && heights[row][col] >= height) {

            seen[row][col] = true;

            dfs(row + 1, col, heights[row][col], heights, seen);
            dfs(row - 1, col, heights[row][col], heights, seen);
            dfs(row, col + 1, heights[row][col], heights, seen);
            dfs(row, col - 1, heights[row][col], heights, seen);
        }
    }
}
// @lc code=end

