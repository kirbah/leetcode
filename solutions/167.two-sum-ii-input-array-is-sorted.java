/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;
        while (first < last) {
            int sum = numbers[first] + numbers[last];
            if (sum == target) {
                return new int[]{first + 1, last + 1};
            } else if (sum > target) {
                last--;
            } else {
                first++;
            }
        }

        return null;
    }

    public int[] twoSum_V2(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (sum > target) {
                    break;
                }
                j++;
            }
        }
        return null;
    }
}
// @lc code=end

