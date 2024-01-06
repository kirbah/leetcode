#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#

# @lc code=start
from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        resMap = defaultdict(list)
        for s in strs:
            key = [0] * 26
            for c in s:
                key[ord(c) - ord("a")] += 1
            resMap[tuple(key)].append(s)

        return list(resMap.values())


    def groupAnagramsV1(self, strs: List[str]) -> List[List[str]]:
        resMap = defaultdict(list)
        for s in strs:
            key = tuple(sorted(s))
            resMap[key].append(s)

        return list(resMap.values())

# @lc code=end

