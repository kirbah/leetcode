#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        def fib(n):
            a, b = 0, 1
            for _ in range(n):
                a, b = b, a + b
                yield b

        return list(fib(n))[-1] if n > 0 else 0

    def climbStairs_fb(self, n: int) -> int:
        a, b = 1, 1
        for _ in range(2, n + 1):
            a, b = b, a + b

        return b

    def climbStairs_dp(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]


# @lc code=end

