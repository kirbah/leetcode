#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        prev_house, last_house = 0, 0
        for num in nums:
            prev_house, last_house = last_house, max(last_house, prev_house + num)

        return last_house

    def rob_v2(self, nums: List[int]) -> int:
        num_houses = len(nums)
        if num_houses == 0:
            return 0
        if num_houses == 1:
            return nums[0]

        # Dynamic programming to find the maximum loot
        dp = [0] * num_houses
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, num_houses):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[num_houses - 1]

# @lc code=end

