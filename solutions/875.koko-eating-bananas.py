#
# @lc app=leetcode id=875 lang=python3
#
# [875] Koko Eating Bananas
#

# @lc code=start
import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low = 1
        high = max(piles)
        while low < high:
            middle = (low + high) // 2
            spent_hours = sum(math.ceil(float(p) / middle) for p in piles)
            if spent_hours <= h:
                high = middle
            else:
                low = middle + 1

        return high

# @lc code=end

