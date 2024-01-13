#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#

# @lc code=start
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        n = len(nums) - 1
        for i, a in enumerate(nums):
            if i > 0 and a == nums[i - 1]:
                continue
            left = i + 1
            right = n

            while left < right:
                b = nums[left]
                c = nums[right]
                sum = a + b + c
                if sum == 0:
                    res.append([a, b, c])
                    while left < right and b == nums[left + 1]:
                        left += 1
                    while left < right and c == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif sum < 0:
                    left += 1
                else:
                    right -= 1

        return res

# @lc code=end

