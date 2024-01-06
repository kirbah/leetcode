#
# @lc app=leetcode id=853 lang=python3
#
# [853] Car Fleet
#

# @lc code=start
from typing import List


class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), reverse=True)
        fleets = 0
        lead_car_time = -1

        for pos, spd in cars:
            time_to_reach_target = (target - pos) / spd

            if time_to_reach_target > lead_car_time:
                fleets += 1
                lead_car_time = time_to_reach_target

        return fleets

# @lc code=end

