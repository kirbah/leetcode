#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        palindrome_start, palindrome_len = 0, 0

        def expand(left, right):
            nonlocal palindrome_start, palindrome_len
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            if palindrome_len < right - left - 1:
                palindrome_len = right - left - 1
                palindrome_start = left + 1

        for i in range(len(s)):
            expand(i, i)
            expand(i, i + 1)

        return s[palindrome_start: palindrome_start + palindrome_len]
        
# @lc code=end

