/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            posMap.merge(position[i], i, (prev, curr) -> curr);
        }

        int[] sorted = Arrays.copyOf(position, position.length);
        Arrays.sort(sorted);

        double prevCarTime = -1;
        int fleets = 0;
        for (int i = sorted.length - 1; i >= 0; i--) {
            int pos = sorted[i];
            double carTime = (double) (target - pos) / speed[posMap.get(pos)];
            if (prevCarTime < carTime) {
                fleets++;
                prevCarTime = carTime;
            }
        }

        return fleets;
    }
}
// @lc code=end

