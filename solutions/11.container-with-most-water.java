/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            while (height[left] == 0 && left < right) {
                left++;
            }
            while (height[right] == 0 && left < right) {
                right--;
            }
            int hleft = height[left];
            int hright = height[right];
            if (left < right && hleft > 0 && hright > 0) {
                int area = (right - left) * Math.min(hleft, hright);
                maxArea = Math.max(maxArea, area);
            }
            if (hleft < hright) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
// @lc code=end

