#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#

# @lc code=start
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])

        def dfs(row, col, position) -> bool:
            if row < 0 or col < 0 or row >= rows or col >= cols or board[row][col] != word[position]:
                return False
            if position == len(word) - 1:
                return True

            old_value_at_position = board[row][col]
            board[row][col] = '#'   # Mark visitied cell to prevent second pass over it

            next_position = position + 1
            is_exists = dfs(row + 1, col, next_position) or \
                        dfs(row - 1, col, next_position) or \
                        dfs(row, col + 1, next_position) or \
                        dfs(row, col - 1, next_position)

            board[row][col] = old_value_at_position
            return is_exists

        for r in range(rows):
            for c in range(cols):
                if dfs(r, c, 0):
                    return True

        return False

# @lc code=end

