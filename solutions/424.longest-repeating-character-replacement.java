/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2) {
            return 1;
        }
        int res = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            if (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int characterReplacement_MinMem(String s, int k) {
        if (s.length() < 2) {
            return 1;
        }
        int res = 0;
        int firstReplacement = 0;
        int totalReplacements = 0;
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                if (totalReplacements < k) {
                    if (totalReplacements == 0) {
                        firstReplacement = right;
                    }
                    right++;
                    totalReplacements++;
                } else {
                    res = Math.max(res, right - left);
                    if (totalReplacements > 0) {
                        left = firstReplacement;
                        totalReplacements = 0;
                    } else {
                        left = right;
                    }
                    right = left + 1;
                }
            } else {
                right++;
            }
        }
        // Add possible extra replacement. That might be added at the beginning of string
        if (left > 0 && totalReplacements < k) {
            left -= (k - totalReplacements);
            left = left < 0 ? 0 : left;
        }
        res = Math.max(res, right - left);
        // Special case. re-check last piece backward
        right = s.length() - 1;
        left = right - 1;
        totalReplacements = 0;
        while (left >= 0) {
            if (s.charAt(left) != s.charAt(right)) {
                if (totalReplacements < k) {
                    totalReplacements++;
                    left--;
                } else {
                    break;
                }
            } else {
                left--;
            }            
        }
        return Math.max(res, right - left);
    }

    public int characterReplacement_doublePass(String s, int k) {
        if (s.length() < 2) {
            return 1;
        }
        int res = 0;
        res = onePass(s, k, res);
        res = onePass(new StringBuilder(s).reverse().toString(), k, res);
        return res;
    }

    private int onePass(String s, int k, int res) {
        List<Integer> replacedIdx = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                if (replacedIdx.size() < k) {
                    replacedIdx.add(right++);
                } else {
                    res = Math.max(res, right - left);
                    if (!replacedIdx.isEmpty()) {
                        left = replacedIdx.get(0);
                        replacedIdx = new ArrayList<>();
                    } else {
                        left = right;
                    }
                    right = left + 1;
                }
            } else {
                right++;
            }
        }
        if (left > 0 && replacedIdx.size() < k) {
            left--;
        }
        return Math.max(res, right - left);
    }

}
// @lc code=end

