/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        addParenthesis(n, 1, 0, "(");
        return res;
    }

    public void addParenthesis(int n, int open, int closed, String current) {
        if (open == n && closed == n) {
            res.add(current);
        } else {
            if (open < n) {
                addParenthesis(n, open+1, closed, current + "(");
            }
            if (closed < open) {
                addParenthesis(n, open, closed+1, current + ")");
            }
        }
    }

}
// @lc code=end

