/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int palindroms = 0;
        for(int index = 0; index < s.length(); index++) {
            palindroms += expand(s, index, index);
            palindroms += expand(s, index, index + 1);
        }
        return palindroms;
    }

    private int expand(String s, int left, int right) {
        int counter = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            counter++;
            left--;
            right++;
        }
        return counter;
    }
}
// @lc code=end

