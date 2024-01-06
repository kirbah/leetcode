/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> key = new HashMap<>();
            for (Character c : s.toCharArray()) {
                key.computeIfAbsent(c, k -> 0);
                key.computeIfPresent(c, (k, value) -> value + 1);
            }
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagramsV1(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
// @lc code=end

