#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#

# @lc code=start
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        left_pos = 0
        right_pos = len(height) - 1
        left_max_height = height[left_pos]
        right_max_height = height[right_pos]

        while left_pos < right_pos:
            border_height = min(left_max_height, right_max_height)
            current_height = 0
            if left_max_height <= right_max_height:
                left_pos += 1
                current_height = height[left_pos]
                left_max_height = max(left_max_height, height[left_pos])
            else:
                right_pos -= 1
                current_height = height[right_pos]
                right_max_height = max(right_max_height, height[right_pos])
            water = border_height - current_height
            res += water if water > 0 else 0

        return res

# @lc code=end

