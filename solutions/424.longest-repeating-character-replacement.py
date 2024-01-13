#
# @lc app=leetcode id=424 lang=python3
#
# [424] Longest Repeating Character Replacement
#

# @lc code=start
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res = 0
        maxFreq = 0
        freq = [0] * 26
        left = 0
        for right, c in enumerate(s):
            freq[ord(c) - ord('A')] += 1
            maxFreq = max(maxFreq, freq[ord(c) - ord('A')])
            if right - left + 1 - maxFreq <= k:
                res = max(res, right - left + 1)
            else:
                freq[ord(s[left]) - ord('A')] -= 1
                left += 1

        return res

# @lc code=end

