#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def dfs(index, current: List[int], remain):
            if remain == 0:
                result.append(current.copy())
            elif remain > 0:
                for i in range(index, len(candidates)):
                    current.append(candidates[i])
                    dfs(i, current, remain - candidates[i])
                    current.pop()

        candidates.sort()
        dfs(0, [], target)

        return result

# @lc code=end

