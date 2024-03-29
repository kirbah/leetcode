#
# @lc app=leetcode id=322 lang=python3
#
# [322] Coin Change
#

# @lc code=start
from typing import List


class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] + [amount + 1] * amount    # Init. Set 0 as first value and above max for rest

        for coin in coins:
            for current_amount in range(coin, amount + 1):
                dp[current_amount] = min(dp[current_amount], dp[current_amount - coin] + 1)

        return dp[amount] if dp[amount] != amount + 1 else -1


    def coinChange_v2(self, coins: List[int], amount: int) -> int:
        dp = [0] + [amount + 1] * amount    # Init. Set 0 as first value and above max for rest

        for current_amount in range(amount + 1):
            for coin in coins:
                if current_amount - coin >= 0:
                    dp[current_amount] = min(dp[current_amount], dp[current_amount - coin] + 1)

        return dp[amount] if dp[amount] != amount + 1 else -1


    def coinChange_v3(self, coins: List[int], amount: int) -> int:
        dp = [0] + [amount + 1] * amount    # Init. Set 0 as first value and above max for rest
        dp_counted = [True] + [False] * amount      # First result is pre-counted

        def change(amount):
            if dp_counted[amount]:
                return dp[amount]

            for coin in coins:
                if amount - coin >= 0:
                    sub_problem = change(amount - coin)
                    dp[amount] = min(dp[amount], sub_problem + 1)

            dp_counted[amount] = True
            return dp[amount]

        change(amount)
        return dp[amount] if dp[amount] != amount + 1 else -1

        
# @lc code=end

