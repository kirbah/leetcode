#
# @lc app=leetcode id=213 lang=python3
#
# [213] House Robber II
#

# @lc code=start
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        def rob(begin, end):
            prev_house, last_house = 0, 0
            for i in range(begin, end + 1):
                prev_house, last_house = last_house, max(last_house, prev_house + nums[i])
            return last_house

        return max(rob(0, len(nums) - 2), rob(1, len(nums) - 1))

# @lc code=end

