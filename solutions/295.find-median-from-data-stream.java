/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> bigNumbers;

    public MedianFinder() {
        smallNumbers = new PriorityQueue<>(Comparator.reverseOrder());
        bigNumbers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallNumbers.isEmpty() || num < smallNumbers.peek()) {
            smallNumbers.offer(num);
        } else {
            bigNumbers.offer(num);
        }

        if (smallNumbers.size() - bigNumbers.size() > 1) {
            bigNumbers.offer(smallNumbers.poll());
        } else if (bigNumbers.size() - smallNumbers.size() > 1) {
            smallNumbers.offer(bigNumbers.poll());
        }
    }

    public double findMedian() {
        if (smallNumbers.size() == bigNumbers.size()) {
            return (smallNumbers.peek() + bigNumbers.peek()) / 2.0;
        } else if (smallNumbers.size() > bigNumbers.size()) {
            return smallNumbers.peek();
        }
        return bigNumbers.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

