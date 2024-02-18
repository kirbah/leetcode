/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int palindromeLength = 0;
        int palindromeStart = 0;
        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            // Odd length
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (palindromeLength < right - left - 1) {
                palindromeLength = right - left - 1;
                palindromeStart = left + 1;
            }

            // Even lenth
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (palindromeLength < right - left - 1) {
                palindromeLength = right - left - 1;
                palindromeStart = left + 1;
            }
        }
        return s.substring(palindromeStart, palindromeStart + palindromeLength);
    }
}
// @lc code=end

