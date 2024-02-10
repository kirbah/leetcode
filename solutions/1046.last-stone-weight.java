/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if (stone1 != stone2) {
                queue.add(stone1 - stone2);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
// @lc code=end

