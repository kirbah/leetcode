/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] big = nums1.length <= nums2.length ? nums2 : nums1;

        double result = 0;
        int total = small.length + big.length;
        int half = (total + 1) / 2;
        int left = 0;
        int right = small.length;
        while (left <= right) {
            int smallMiddle = (left + right) >>> 1;
            int bigMiddle = half - smallMiddle;

            int smallLeft = smallMiddle > 0 ? small[smallMiddle - 1] : Integer.MIN_VALUE;
            int smallRight = smallMiddle < small.length ? small[smallMiddle] : Integer.MAX_VALUE;
            int bigLeft = bigMiddle > 0 ? big[bigMiddle - 1] : Integer.MIN_VALUE;
            int bigRight = bigMiddle < big.length ? big[bigMiddle] : Integer.MAX_VALUE;

            if (smallLeft <= bigRight && bigLeft <= smallRight) {
                if (total % 2 != 0) {
                    result = Math.max(smallLeft, bigLeft);
                } else {
                    result = (Math.max(smallLeft, bigLeft) + Math.min(smallRight, bigRight)) / 2.0;
                }
                break;
            } else if (smallLeft > bigRight) {
                right = smallMiddle - 1;
            } else {
                left = smallMiddle + 1;
            }
        }

        return result;
    }
}
// @lc code=end

