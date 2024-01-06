#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def addParenthesis(open: int, closed: int, current: str) -> None:
            if open == closed == n:
                res.append(current)
            else:
                if open < n:
                    addParenthesis(open + 1, closed, current + "(")
                if closed < open:
                    addParenthesis(open, closed + 1, current + ")")

        addParenthesis(1, 0, "(")
        return res

        
# @lc code=end

