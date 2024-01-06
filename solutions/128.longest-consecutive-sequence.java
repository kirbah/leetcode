/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nset = new HashSet<>(nums.length);
        for (int i : nums) {
            nset.add(i);
        }

        int maxSize = 0;
        for (int i : nums) {
            if (!nset.contains(i-1)) {
                int last = i+1;
                while (nset.contains(last)) {
                    last++;
                }
                int size = last - i;
                maxSize = Math.max(size, maxSize);
            }
            if (maxSize > nums.length / 2) break;
        }
        return maxSize;
    }
}
// @lc code=end

