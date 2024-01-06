#
# @lc app=leetcode id=150 lang=python3
#
# [150] Evaluate Reverse Polish Notation
#

# @lc code=start
from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operations = {
            '+': lambda x, y: x + y,
            '-': lambda x, y: y - x,
            '*': lambda x, y: x * y,
            '/': lambda x, y: int(y / x),
        }
        stack = []

        for token in tokens:
            if token in operations:
                stack.append(operations[token](stack.pop(), stack.pop()))
            else:
                stack.append(int(token))

        return stack[0]

# @lc code=end

