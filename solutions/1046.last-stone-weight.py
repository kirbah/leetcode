#
# @lc app=leetcode id=1046 lang=python3
#
# [1046] Last Stone Weight
#

# @lc code=start
import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap_stones = [-s for s in stones]
        heapq.heapify(heap_stones)

        while len(heap_stones) > 1:
            stone1 = heapq.heappop(heap_stones)
            stone2 = heapq.heappop(heap_stones)
            if stone1 != stone2:
                heapq.heappush(heap_stones, stone1 - stone2)

        return -heap_stones[0] if heap_stones else 0

# @lc code=end

