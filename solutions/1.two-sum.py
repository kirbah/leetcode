#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num = {}

        for key1, val1 in enumerate(nums):
            val2 = target - val1
            if val2 in num:
                key2 = num[val2]
                if key1 != key2:
                    return [key1, key2]
            else:
                num[val1] = key1

        return None

# @lc code=end

