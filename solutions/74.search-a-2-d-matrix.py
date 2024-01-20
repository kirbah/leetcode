#
# @lc app=leetcode id=74 lang=python3
#
# [74] Search a 2D Matrix
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])

        low = 0
        high = rows * cols - 1

        while low <= high:
            mid = (low + high) // 2
            mid_value = matrix[mid // cols][mid % cols]

            if mid_value < target:
                low = mid + 1
            elif mid_value > target:
                high = mid - 1
            else:
                return True

        return False

# @lc code=end

