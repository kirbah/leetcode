#
# @lc app=leetcode id=91 lang=python3
#
# [91] Decode Ways
#

# @lc code=start
class Solution:

    def numDecodings(self, s: str) -> int:
        num = len(s)
        dp_second = 1     # dp[num] Used to correctly increment the very last 2 digits string case
        dp_first = 1 if s[num - 1] != '0' else 0   # dp[num - 1] Number of valid decodings of very last char

        for i in reversed(range(num - 1)):
            dp_current = 0
            if s[i] != '0':
                dp_current += dp_first
            if s[i] == '1' or (s[i] == '2' and s[i + 1] < '7'):
                dp_current += dp_second
            dp_first, dp_second = dp_current, dp_first

        return dp_first


    def numDecodings_dp(self, s: str) -> int:
        num = len(s)
        dp = [0] * num + [1]     # dp[num] Used to correctly increment the very last 2 digits string case
        dp[num - 1] = 1 if s[num - 1] != '0' else 0   # dp[num - 1] Number of valid decodings of very last char

        for i in reversed(range(num - 1)):
            if s[i] != '0':
                dp[i] += dp[i + 1]
            if s[i] == '1' or (s[i] == '2' and s[i + 1] < '7'):
                dp[i] += dp[i + 2]

        return dp[0]
        
# @lc code=end

