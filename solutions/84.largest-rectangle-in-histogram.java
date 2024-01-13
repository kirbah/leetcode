/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Bar> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int startPosition = i;
            while (!stack.empty() && stack.peek().getHeight() > currentHeight) {
                Bar poppedBar = stack.pop();
                int area = poppedBar.getHeight() * (i - poppedBar.getPosition());
                maxArea = Math.max(maxArea, area);
                startPosition = poppedBar.getPosition();
            }
            stack.push(new Bar(currentHeight, startPosition));
        }
        maxArea = processStack(stack, heights.length, 0, maxArea);
        return maxArea;
    }

    public int largestRectangleArea_V2(int[] heights) {
        Stack<Bar> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];

            if (stack.empty()) {
                stack.push(new Bar(currentHeight, i));
            } else {
                int prevHeight = stack.peek().getHeight();
                if (currentHeight > prevHeight) {
                    stack.push(new Bar(currentHeight, i));
                }
                Bar barToPush = null;
                if (currentHeight < prevHeight) {
                    int firstHeightPosition = i;
                    int stackIndex = stack.size() - 1;
                    while (stackIndex >= 0 && stack.get(stackIndex).getHeight() >= currentHeight) {
                        firstHeightPosition = stack.get(stackIndex).getPosition();
                        stackIndex--;
                    }
                    barToPush = new Bar(currentHeight, firstHeightPosition);
                }

                maxArea = processStack(stack, i, currentHeight, maxArea);
                if (barToPush != null) {
                    stack.push(barToPush);
                }
            }
        }
        maxArea = processStack(stack, heights.length, 0, maxArea);
        return maxArea;
    }

    private int processStack(Stack<Bar> stack, int currentPos, int currentHeight, int maxArea) {
        while (!stack.isEmpty() && currentHeight < stack.peek().getHeight()) {
            Bar poppedBar = stack.pop();
            int area = poppedBar.getHeight() * (currentPos - poppedBar.getPosition());
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static class Bar {
        private final int height;
        private final int position;

        Bar(int height, int position) {
            this.height = height;
            this.position = position;
        }

        public int getHeight() {
            return height;
        }

        public int getPosition() {
            return position;
        }
    }

}
// @lc code=end

