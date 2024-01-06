#
# @lc app=leetcode id=128 lang=python3
#
# [128] Longest Consecutive Sequence
#

# @lc code=start

from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nset = set(nums)
        maxSize = 0
        for i in nset:
            if (i-1) not in nset:
                last = i+1
                while last in nset:
                    last += 1
                size = last - i
                maxSize = max(maxSize, size)

            if maxSize > len(nums) // 2:
                break

        return maxSize

# @lc code=end

