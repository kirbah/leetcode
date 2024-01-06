#
# @lc app=leetcode id=347 lang=python3
#
# [347] Top K Frequent Elements
#

# @lc code=start
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for i in nums:
            freq[i] = freq.get(i, 0) + 1
        
        freqToIndex = [[] for _ in range(len(nums) + 1)]
        for key, val in freq.items():
            freqToIndex[val].append(key)
        
        res = []
        index = len(nums)
        while len(res) < k:
            res.extend(freqToIndex[index])
            index -= 1

        return res

# @lc code=end

