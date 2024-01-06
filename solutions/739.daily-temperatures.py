#
# @lc app=leetcode id=739 lang=python3
#
# [739] Daily Temperatures
#

# @lc code=start
from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = []
        for pos, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                prevPos = stack.pop()
                res[prevPos] = pos - prevPos
            stack.append(pos)

        return res

# @lc code=end

