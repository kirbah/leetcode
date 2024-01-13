#
# @lc app=leetcode id=167 lang=python3
#
# [167] Two Sum II - Input Array Is Sorted
#

# @lc code=start
from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        first = 0
        last = len(numbers) - 1

        while first < last:
            sum = numbers[first] + numbers[last]
            if sum == target:
                return [first + 1, last + 1]
            elif sum > target:
                last -= 1
            else:
                first += 1
   
        return None

# @lc code=end

