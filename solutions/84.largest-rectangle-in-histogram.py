#
# @lc app=leetcode id=84 lang=python3
#
# [84] Largest Rectangle in Histogram
#

# @lc code=start
from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []  # height, position
        maxArea = 0

        for index, currentHeight in enumerate(heights):
            startPosition = index
            while stack and stack[-1][0] > currentHeight:
                poppedHeight, poppedPosition = stack.pop()
                area = poppedHeight * (index - poppedPosition)
                maxArea = max(maxArea, area)
                startPosition = poppedPosition
            stack.append([currentHeight, startPosition])

        n = len(heights)
        for height, position in stack:
            maxArea = max(maxArea, height * (n - position))

        return maxArea

# @lc code=end

