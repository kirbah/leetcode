/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }
}

// @lc code=end

