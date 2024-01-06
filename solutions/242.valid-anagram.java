/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (count.containsKey(c)) {
                int res = count.get(c) - 1;
                if (res > 0) {
                    count.put(c, res);
                } else {
                    count.remove(c);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

