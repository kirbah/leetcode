/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start


class Solution {
    public int trap(int[] height) {
        int res = 0;
        int leftPos = 0;
        int rightPos = height.length - 1;
        int leftMaxHeight = height[leftPos];
        int rightMaxHeight = height[rightPos];

        while (leftPos < rightPos) {
            int borderHeight = Math.min(leftMaxHeight, rightMaxHeight);
            int currentHeight = 0;
            if (leftMaxHeight <= rightMaxHeight) {
                currentHeight = height[++leftPos];
                leftMaxHeight = Math.max(leftMaxHeight, height[leftPos]);
            } else {
                currentHeight = height[--rightPos];
                rightMaxHeight = Math.max(rightMaxHeight,  height[rightPos]);
            }
            int water = borderHeight - currentHeight;
            res += water > 0 ? water : 0;
        }

        return res;
    }
}
// @lc code=end

