#
# @lc app=leetcode id=207 lang=python3
#
# [207] Course Schedule
#

# @lc code=start
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courses = [[] for _ in range(numCourses)]
        for pair in prerequisites:
            courses[pair[0]].append(pair[1])

        def has_cycle(index):
            if visited[index] == 1:
                return True     # visiting. cycle detected
            if visited[index] == 2:
                return False    # visited. no need to check child second time

            visited[index] = 1
            for child in courses[index]:
                if has_cycle(child):
                    return True
            visited[index] = 2

            return False

        visited = [0] * numCourses
        for index in range(numCourses):
            if visited[index] == 0 and has_cycle(index):
                return False
            
        return True

# @lc code=end

