/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

class Solution {
    public int evalRPN(String[] tokens) {
        java.util.Map<String, BinaryOperator<Integer>> operations = Map.of(
            "+", (x, y) -> x + y,
            "-", (x, y) -> y - x,
            "*", (x, y) -> x * y,
            "/", (x, y) -> y / x
        );
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operations.containsKey(token)) {
                stack.push(operations.get(token).apply(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public int evalRPN_V2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int i1 = stack.pop();
                    int i2 = stack.pop();
                    stack.push(i2 / i1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
// @lc code=end

