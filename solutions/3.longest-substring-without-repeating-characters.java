/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return res;
    }

    public int lengthOfLongestSubstring_V2(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        for(char c : s.toCharArray()) {
            right++;
            if (set.contains(c)) {
                while (s.charAt(left) != c)  {
                    set.remove(s.charAt(left++));
                }
                left++;
            } else {
                set.add(c);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end

