/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().orElseThrow();
        while (min < max) {
            int middle = (min + max) >>> 1;
            int spentHours = 0;
            for(int i = 0; i < piles.length; i++) {
                spentHours += Math.ceilDiv(piles[i], middle);
            }
            if (spentHours <= h) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        return max;
    }
}
// @lc code=end

