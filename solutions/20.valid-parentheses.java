/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (mapping.containsKey(ch)) {
                if (stack.isEmpty() || mapping.get(ch) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

