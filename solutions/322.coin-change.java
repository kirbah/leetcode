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

    // Too slow to pass test :(
    public int coinChange_rec(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean[] dpCounted = new boolean[amount + 1];
        return change(dp, dpCounted, coins, amount);
    }

    private int change(int[] dp, boolean[] dpCounted, int[] coins, int left) {
        if (left == 0) return 0;
        if (left < 0) return -1;
        if (dpCounted[left]) return dp[left];

        for(int coin : coins) {
            if (left - coin >= 0) {
                int subproblem = change(dp, dpCounted, coins, left - coin);
                if (subproblem >= 0) {
                    dp[left] = Math.min(subproblem + 1, dp[left]);
                    dpCounted[left] = true;
                }
            }
        }

        return dpCounted[left] ? dp[left] : -1;
    }
}
// @lc code=end

