/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int prevHouse = 0;
        int lastHouse = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(lastHouse, prevHouse + nums[i]);
            prevHouse = lastHouse;
            lastHouse = temp;
        }
        return lastHouse;
    }

    public int rob_v2(int[] nums) {
        int numHouses = nums.length;
        if (numHouses == 0) return 0;
        if (numHouses == 1) return nums[0];

        // Dynamic programming to find the maximum loot
        int[] dp = new int[numHouses];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < numHouses; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[numHouses - 1];
    }
}
// @lc code=end

