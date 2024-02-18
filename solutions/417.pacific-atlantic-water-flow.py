#
# @lc app=leetcode id=417 lang=python3
#
# [417] Pacific Atlantic Water Flow
#

# @lc code=start
from typing import List


class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])
        seen_pacific = [[False] * cols for _ in range(rows)]
        seen_atlantic = [[False] * cols for _ in range(rows)]

        def dfs(row, col, height, seen):
            if 0 <= row < rows and 0 <= col < cols \
                and height <= heights[row][col] and not seen[row][col]:

                seen[row][col] = True

                dfs(row + 1, col, heights[row][col], seen)
                dfs(row - 1, col, heights[row][col], seen)
                dfs(row, col + 1, heights[row][col], seen)
                dfs(row, col - 1, heights[row][col], seen)

        for row in range(rows):
            dfs(row, 0, heights[row][0], seen_pacific)
            dfs(row, cols - 1, heights[row][cols - 1], seen_atlantic)

        for col in range(cols):
            dfs(0, col, heights[0][col], seen_pacific)
            dfs(rows - 1, col, heights[rows - 1][col], seen_atlantic)

        result = []
        for row in range(rows):
            for col in range(cols):
                if seen_atlantic[row][col] and seen_pacific[row][col]:
                    result.append([row, col])

        return result


# @lc code=end

