/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>(k + 1);
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(right);

            if (left > deque.peekFirst()) {
                deque.pollFirst();
            }

            if (right + 1 >= k) {
                result[resultIndex++] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }

        return result;
    }
}
// @lc code=end

