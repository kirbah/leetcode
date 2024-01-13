#
# @lc app=leetcode id=567 lang=python3
#
# [567] Permutation in String
#

# @lc code=start
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        s1_counter = [0] * 26
        s2_counter = [0] * 26
        n = len(s1)
        for i in range(n):
            s1_counter[ord(s1[i]) - ord('a')] += 1
            s2_counter[ord(s2[i]) - ord('a')] += 1

        matches = 0
        for i in range(26):
            if s1_counter[i] == s2_counter[i]:
                matches += 1

        for i in range(n, len(s2)):
            if matches == 26:
                return True

            add_index = ord(s2[i]) - ord('a')
            s2_counter[add_index] += 1
            if s1_counter[add_index] == s2_counter[add_index]:
                matches += 1
            elif s1_counter[add_index] + 1 == s2_counter[add_index]:
                matches -= 1

            del_index = ord(s2[i - n]) - ord('a')
            s2_counter[del_index] -= 1
            if s1_counter[del_index] == s2_counter[del_index]:
                matches += 1
            elif s1_counter[del_index] - 1 == s2_counter[del_index]:
                matches -= 1

        return matches == 26

# @lc code=end

