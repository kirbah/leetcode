/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }

        List<List<Integer>> freqToIndex = new ArrayList<>(nums.length);
        for (int i = 0; i <= nums.length; i++) {
            freqToIndex.add(new ArrayList<>());
        }

        for (int i : freq.keySet()) {
            int count = freq.get(i);
            freqToIndex.get(count).add(i);
        }

        List<Integer> res = new ArrayList<>(k);
        int index = nums.length;
        while (res.size() < k) {
            res.addAll(freqToIndex.get(index--));
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

