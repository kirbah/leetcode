/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.merge(c, 1, Integer::sum);
        }

        int resLeft = 0;
        int resRight = -1;
        int left = 0;
        int right = 0;
        int matches = 0;
        while (right < s.length()) {
            Character charRight = s.charAt(right);
            if (tMap.containsKey(charRight)) {
                tMap.put(charRight, tMap.get(charRight) - 1);
                if (tMap.get(charRight) == 0) {
                    matches++;
                }
                while (matches == tMap.size()) {
                    if (resRight == -1 || (resRight - resLeft > right - left)) {
                        resLeft = left;
                        resRight = right;
                        if (right - left + 1 == t.length()) {
                            return s.substring(resLeft, resRight + 1);
                        }
                    }
                    Character charLeft = s.charAt(left++);
                    if (tMap.containsKey(charLeft)) {
                        if (tMap.get(charLeft) == 0) {
                            matches--;
                        }
                        tMap.put(charLeft, tMap.get(charLeft) + 1);
                    }
                }
            }
            right++;
        }

        return (resRight == -1) ? "" : s.substring(resLeft, resRight + 1);
    }
}
// @lc code=end

