#
# @lc app=leetcode id=76 lang=python3
#
# [76] Minimum Window Substring
#

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""

        map = {}
        for c in t:
            map[c] = map.get(c, 0) + 1

        res_left = 0
        res_right = -1
        left = 0
        right = 0
        matches = 0
        while right < len(s):
            char_add = s[right]
            if char_add in map:
                map[char_add] -= 1
                if map[char_add] == 0:
                    matches += 1

                while matches == len(map):
                    if res_right == -1 or res_right - res_left > right - left:
                        res_right = right
                        res_left = left
                        if right - left + 1 == len(t):
                            return s[res_left : res_right + 1]

                    char_del = s[left]
                    if char_del in map:
                        if map[char_del] == 0:
                            matches -= 1
                        map[char_del] += 1
                    left += 1

            right += 1

        return s[res_left : res_right + 1] if res_right > -1 else ""

# @lc code=end

