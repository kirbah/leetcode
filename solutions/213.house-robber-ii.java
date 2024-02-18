/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int begin, int end) {
        int prevHouse = 0;
        int lastHouse = 0;
        for(int i = begin; i <= end; i++) {
            int temp = Math.max(lastHouse, prevHouse + nums[i]);
            prevHouse = lastHouse;
            lastHouse = temp;
        }
        return lastHouse;
    }
}
// @lc code=end

