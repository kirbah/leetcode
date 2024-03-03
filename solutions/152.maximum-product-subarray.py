#
# @lc app=leetcode id=152 lang=python3
#
# [152] Maximum Product Subarray
#

# @lc code=start
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = min_val = max_val = nums[0]

        for num in nums[1:]:
            if num < 0:
                min_val, max_val = max_val, min_val     # swap max and min in case of negative number

            min_val = min(num, num * min_val)
            max_val = max(num, num * max_val)
            res = max(res, max_val)

        return res

# @lc code=end

