/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int pos = 0; pos < n; pos++) {
            int temp = temperatures[pos];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                Integer prevPos = stack.pop();
                res[prevPos] = pos - prevPos;
            }
            stack.push(pos);
        }
        return res;
    }
}
// @lc code=end

