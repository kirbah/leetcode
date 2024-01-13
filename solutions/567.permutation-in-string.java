/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.math.BigDecimal;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n = s1.length();
        int[] s1Counter = new int[26];
        int[] s2Counter = new int[26];
        for(int i = 0; i < n; i++) {
            s1Counter[s1.charAt(i) - 'a'] += 1;
            s2Counter[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;
        for(int i = 0; i < s1Counter.length; i++) {
            if (s1Counter[i] == s2Counter[i]) {
                matches++;
            }
        }

        for(int i = n; i < s2.length(); i++) {
            if (matches == 26) {
                return true;
            }
            int addPos = s2.charAt(i) - 'a';
            int delPos = s2.charAt(i - n) - 'a';

            s2Counter[addPos] += 1;
            if (s1Counter[addPos] == s2Counter[addPos]) {
                matches++;
            } else if (s1Counter[addPos] + 1 == s2Counter[addPos]) {
                matches--;
            }

            s2Counter[delPos] -= 1;
            if (s1Counter[delPos] == s2Counter[delPos]) {
                matches++;
            } else if (s1Counter[delPos] - 1 == s2Counter[delPos]) {
                matches--;
            }
        }

        return matches == 26;
    }

    public boolean checkInclusion_V2(String s1, String s2) {
        BigDecimal s1Counter = new BigDecimal(0);
        BigDecimal s2Counter = new BigDecimal(0);
        for (char c : s1.toCharArray()) {
            s1Counter = s1Counter.add(getNumber(c));
        }
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            if (right - left >= s1.length()) {
                s2Counter = s2Counter.subtract(getNumber(s2.charAt(left++)));
            }
            s2Counter = s2Counter.add(getNumber(s2.charAt(right)));
            if (s1Counter.equals(s2Counter)) {
                return true;
            }
        }
        return false;
    }

    private BigDecimal getNumber(char c) {
        int scale = (c - 'a') * 4;
        return new BigDecimal(1).scaleByPowerOfTen(scale);
    }
}
// @lc code=end

