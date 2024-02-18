#
# @lc app=leetcode id=647 lang=python3
#
# [647] Palindromic Substrings
#

# @lc code=start
class Solution:
    def countSubstrings(self, s: str) -> int:
        palindroms = 0

        def expand(left, right):
            count = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
            return count

        for index in range(len(s)):
            palindroms += expand(index, index)
            palindroms += expand(index, index + 1)

        return palindroms

# @lc code=end

