/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int num = s.length();
        int dpSecond = 1;        // dp[num] Used to correctly increment the very last 2 digits string case
        int dpFirst = isValid(s.charAt(num - 1)) ? 1 : 0; // dp[num - 1] Number of valid decodings of very last char

        for(int i = num - 2; i >= 0; i--) {
            int dpCurrent = 0;
            if (isValid(s.charAt(i))) {
                dpCurrent += dpFirst;
            }
            if (isValid(s.charAt(i), s.charAt(i + 1))) {
                dpCurrent += dpSecond;
            }
            dpSecond = dpFirst;
            dpFirst = dpCurrent;
        }

        return dpFirst;
    }

    public int numDecodings_dp(String s) {
        int num = s.length();
        int[] dp = new int[num + 1];

        dp[num] = 1;        // Used to correctly increment the very last 2 digits string case
        dp[num - 1] = isValid(s.charAt(num - 1)) ? 1 : 0; // Number of valid decodings of very last char
        for(int i = num - 2; i >= 0; i--) {
            if (isValid(s.charAt(i))) {
                dp[i] += dp[i + 1];
            }
            if (isValid(s.charAt(i), s.charAt(i + 1))) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    private boolean isValid(char c) {
        return c != '0';
    }

    private boolean isValid(char c1, char c2) {
        return c1 == '1' || (c1 == '2' && c2 < '7');
    }
}
// @lc code=end

