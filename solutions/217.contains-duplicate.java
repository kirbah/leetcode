/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> counter = new HashSet<>();
        for (int i : nums) {
            if (counter.contains(i)) {
                return true;
            } else {
                counter.add(i);
            }
        }
        return false;
    }
}
// @lc code=end

