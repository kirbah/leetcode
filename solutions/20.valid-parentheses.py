#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        mapping = {')': '(', ']': '[', '}': '{'}
        stack = []
        for ch in s:
            if ch in mapping:
                if not stack or mapping[ch] != stack.pop():
                    return False
            else:
                stack.append(ch)

        return not stack

# @lc code=end

