#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        if len(prices) > 1:
            min = prices[0]
            for i in range(1, len(prices)):
                next = prices[i]
                res = max(res, next - min)
                if next < min:
                    min = next
        return res

# @lc code=end

