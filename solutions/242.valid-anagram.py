#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count = {}
        for char in s:
            count[char] = count.get(char, 0) + 1

        for char in t:
            if char in count:
                res = count.get(char) - 1
                if res > 0:
                    count[char] = res
                else:
                    count.pop(char)
            else:
                return False

        return True

# @lc code=end

