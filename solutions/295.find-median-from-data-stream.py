#
# @lc app=leetcode id=295 lang=python3
#
# [295] Find Median from Data Stream
#

# @lc code=start
import heapq


class MedianFinder:

    def __init__(self):
        self.small_numbers = []
        self.big_numbers = []

    def addNum(self, num: int) -> None:
        if not self.small_numbers or num < -self.small_numbers[0]:
            heapq.heappush(self.small_numbers, -num)
        else:
            heapq.heappush(self.big_numbers, num)

        if len(self.small_numbers) - len(self.big_numbers) > 1:
            heapq.heappush(self.big_numbers, -heapq.heappop(self.small_numbers))
        elif len(self.big_numbers) - len(self.small_numbers) > 1:
            heapq.heappush(self.small_numbers, -heapq.heappop(self.big_numbers))

    def findMedian(self) -> float:
        if len(self.small_numbers) == len(self.big_numbers):
            return (-self.small_numbers[0] + self.big_numbers[0]) / 2.0
        elif len(self.small_numbers) > len(self.big_numbers):
            return -self.small_numbers[0]
        return self.big_numbers[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
# @lc code=end

