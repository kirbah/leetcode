/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] >= nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[right];
    }
}
// @lc code=end

