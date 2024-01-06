#
# @lc app=leetcode id=155 lang=python3
#
# [155] Min Stack
#

# @lc code=start
class MinStack:

    def __init__(self):
        self.store = []
        self.minStore = []

    def push(self, val: int) -> None:
        self.store.append(val)
        if not self.minStore or val < self.minStore[-1]:
            self.minStore.append(val)
        else:
            self.minStore.append(self.minStore[-1])

    def pop(self) -> None:
        self.store.pop()
        self.minStore.pop()

    def top(self) -> int:
        return self.store[-1]

    def getMin(self) -> int:
        return self.minStore[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

