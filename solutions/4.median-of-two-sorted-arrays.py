#
# @lc app=leetcode id=4 lang=python3
#
# [4] Median of Two Sorted Arrays
#

# @lc code=start
import sys
from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        small = nums1 if len(nums1) <= len(nums2) else nums2
        big = nums2 if len(nums1) <= len(nums2) else nums1

        total = len(small) + len(big)
        half = (total + 1) // 2 # round up in case of the odd total length

        result = 0.0
        left = 0
        right = len(small)
        while left <= right:
            small_middle = (left + right) // 2
            big_middle = half - small_middle

            small_left = small[small_middle - 1] if small_middle > 0 else -sys.maxsize
            small_right = small[small_middle] if small_middle < len(small) else sys.maxsize
            big_left = big[big_middle - 1] if big_middle > 0 else -sys.maxsize
            big_right = big[big_middle] if big_middle < len(big) else sys.maxsize

            if small_left <= big_right and big_left <= small_right:
                if total % 2:
                    result = max(small_left, big_left)
                else:
                    result = (max(small_left, big_left) + min(small_right, big_right)) / 2.0
                break
            elif small_left > big_right:
                right = small_middle - 1
            else:
                left = small_middle + 1

        return result

# @lc code=end

