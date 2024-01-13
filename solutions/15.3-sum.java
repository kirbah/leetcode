/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length - 1;
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n;

            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    res.add(Arrays.asList(a, b, c));
                    while (left < right && b == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && c == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

