#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        chars = set()

        left = right = 0
        while right < len(s):
            if not s[right] in chars:
                chars.add(s[right])
                right += 1
                res = max(res, right - left)
            else:
                chars.remove(s[left])
                left += 1

        return res

# @lc code=end

