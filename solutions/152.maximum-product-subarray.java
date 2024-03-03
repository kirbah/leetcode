/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int tmp = min;  // swap max and min in case of negative number
                min = max;
                max = tmp;
            }
            min = Math.min(num, num * min);
            max = Math.max(num, num * max);
            res = Math.max(res, max);
        }

        return res;
    }
}
// @lc code=end

