/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num = new HashMap<>();

        for (int key1 = 0; key1<nums.length; key1++) {
            int val1 = nums[key1];
            int val2 = target - val1;
            if (num.containsKey(val2)) {
                int key2 = num.get(val2);
                if (key1 != key2) {
                    return new int[]{key1 , key2};
                }
            } else {
                num.put(val1, key1);
            }
        }

        return null;
    }
}
// @lc code=end

