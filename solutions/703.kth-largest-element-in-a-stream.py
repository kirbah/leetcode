#
# @lc app=leetcode id=703 lang=python3
#
# [703] Kth Largest Element in a Stream
#

# @lc code=start
import heapq
from typing import List


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.max_values = k
        self.queue = nums

        heapq.heapify(self.queue)
        while len(self.queue) > k:
            heapq.heappop(self.queue)

    def add(self, val: int) -> int:
        if len(self.queue) < self.max_values:
            heapq.heappush(self.queue, val)
        elif val > self.queue[0]:
            heapq.heappop(self.queue)
            heapq.heappush(self.queue, val)

        return self.queue[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
# @lc code=end

