/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length > 1) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int next = prices[i];
                res = Math.max(res, next - min);
                if (next < min) {
                    min = next;
                }
            }
        }
        return res;
    }
}
// @lc code=end

