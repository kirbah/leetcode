/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);  // Init. Keep 0 as first value and above max for rest

        for(int coin : coins) {
            for(int currentAmount = coin; currentAmount <= amount; currentAmount++) {
                dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange_v2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);  // Init. Keep 0 as first value and above max for rest

        for(int currentAmount = 0; currentAmount <= amount; currentAmount++) {
            for(int coin : coins) {
                if (currentAmount - coin >= 0) {
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange_v3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);  // Init. Keep 0 as first value and above max for rest
        boolean[] dpCounted = new boolean[amount + 1];
        dpCounted[0] = true;       // First result is pre-counted

        int res = change(dp, dpCounted, coins, amount);
        return res == amount + 1 ? -1 : res;
    }

    private int change(int[] dp, boolean[] dpCounted, int[] coins, int amount) {
        if (dpCounted[amount]) return dp[amount];

        for(int coin : coins) {
            if (amount - coin >= 0) {
                int subproblem = change(dp, dpCounted, coins, amount - coin);
                dp[amount] = Math.min(subproblem + 1, dp[amount]);
            }
        }
        dpCounted[amount] = true;

        return dp[amount];
    }
}
// @lc code=end

