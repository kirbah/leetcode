#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#

# @lc code=start
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        left = 0
        right = len(height) - 1
        while left < right:
            while left < right and height[left] == 0:
                left += 1
            while left < right and height[right] == 0:
                right -= 1
            if left < right and height[left] > 0 and height[right] > 0:
                area = (right - left) * min(height[left], height[right])
                maxArea = max(maxArea, area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return maxArea

# @lc code=end

