#
# @lc app=leetcode id=981 lang=python3
#
# [981] Time Based Key-Value Store
#

import bisect
from collections import defaultdict

# @lc code=start
class TimeMap:

    def __init__(self):
        self.store = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        values = self.store[key]
        res = ""
        low = 0
        high = len(values) - 1
        while low <= high:
            middle = (low + high) // 2
            if values[middle][0] <= timestamp:
                res = values[middle][1]
                low = middle + 1
            else:
                high = middle - 1

        return res

class TimeMap_bisect:

    def __init__(self):
        self.store = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        values = self.store[key]
        index = bisect.bisect_right(values, (timestamp, chr(127)))
        return values[index - 1][1] if index else ""


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
# @lc code=end

