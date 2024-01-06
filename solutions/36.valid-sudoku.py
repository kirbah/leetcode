#
# @lc app=leetcode id=36 lang=python3
#
# [36] Valid Sudoku
#

# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        columnsCheck = defaultdict(set)
        blockCheck = defaultdict(set)

        for row in range(0, n):
            rowsCheck = set()
            for col in range(0, n):
                current = board[row][col]
                if current == ".":
                    continue

                if (
                    current in columnsCheck[col]
                    or current in rowsCheck
                    or current in blockCheck[row // 3, col // 3]
                ):
                    return False

                columnsCheck[col].add(current)
                rowsCheck.add(current)
                blockCheck[row // 3, col // 3].add(current)

        return True

# @lc code=end

