/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> queue;
    private int maxValues;

    public KthLargest(int k, int[] nums) {
        maxValues = k;
        queue = new PriorityQueue<>(k);
        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < maxValues) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

